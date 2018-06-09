package com.reservation.service.impl;

import com.reservation.dao.AdminDao;
import com.reservation.model.utilisteur.Admin;
import com.reservation.service.utilisateur.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class AdminServiceImpl implements UserDetailsService, AdminService {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Admin user = adminDao.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Admin> findAll() {
		List<Admin> list = new ArrayList<>();
		adminDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		adminDao.delete(id);
	}

	@Override
	public Admin findOne(String username) {
		return adminDao.findByUsername(username);
	}

	@Override
	public Admin findById(Long id) {
		return adminDao.findOne(id);
	}

	@Override
	public Admin save(Admin user) {
		Admin newUser = new Admin();
		newUser.setUsername(user.getUsername());
		
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return adminDao.save(newUser);
	}
	
}

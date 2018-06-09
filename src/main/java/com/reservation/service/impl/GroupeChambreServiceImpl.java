package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.GroupeChambreDao;
import com.reservation.model.hotel.GroupeChambre;
import com.reservation.service.hotel.GroupeChambreService;

@Service(value = "GroupeChambreServiceImpl")

public class GroupeChambreServiceImpl implements GroupeChambreService{

	
	@Autowired
	private GroupeChambreDao chambreDao;
	@Override
	public List<GroupeChambre> findAll() {
		List<GroupeChambre> list = new ArrayList<>();
		chambreDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}

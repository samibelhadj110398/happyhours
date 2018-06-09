package com.reservation.controller;

import com.reservation.model.utilisteur.Admin;
import com.reservation.service.utilisateur.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="api/admin", method = RequestMethod.GET)
    public List<Admin> listAdmin(){
        return adminService.findAll();
    }

    @RequestMapping(value = "api/admin/{id}", method = RequestMethod.GET)
    public Admin getOne(@PathVariable(value = "id") Long id){
        return adminService.findById(id);
    }
    @RequestMapping(value="api/signup", method = RequestMethod.POST)
    public Admin saveUser(@RequestBody Admin user){
    	return adminService.save(user);
    }

}

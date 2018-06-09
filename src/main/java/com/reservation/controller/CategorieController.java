package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Categorie;
import com.reservation.service.CategorieService;

@CrossOrigin(origins = "*")
@RestController
public class CategorieController {

	 @Autowired
	    private CategorieService CategorieService;
	

	    @RequestMapping(value="api/Categorie", method = RequestMethod.GET)
	    public List<Categorie> listCompte(){
	        return CategorieService.findAll();
	    }

	    
}


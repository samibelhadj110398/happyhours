package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.TypeChambreDao;
import com.reservation.model.hotel.TypeChambre;
import com.reservation.service.hotel.TypeChambreService;

@CrossOrigin(origins = "*")
@RestController
public class TypeChambreController {

	
	@Autowired
    private TypeChambreDao typeChambreDao;
	@Autowired
    private TypeChambreService typeChambreService;
	
	  @RequestMapping(value="api/typeChambre/all", method = RequestMethod.GET)
	    public List<TypeChambre> getAllTypeChambre(){
	        return typeChambreService.findAll();
	    }
    
    @RequestMapping(value="api/typeChambre/save", method = RequestMethod.POST)
    public TypeChambre saveCategorieHotel(
    		@RequestBody TypeChambre categorieHotel){
    	return typeChambreDao.save(categorieHotel);
    }
	
}

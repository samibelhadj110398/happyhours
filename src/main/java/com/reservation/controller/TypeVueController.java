package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.TypeVueDao;
import com.reservation.model.hotel.TypeVue;
import com.reservation.service.hotel.TypeVueService;
@CrossOrigin(origins = "*")
@RestController
public class TypeVueController {
	@Autowired
    private TypeVueDao typeVueDao;
	@Autowired
    private TypeVueService typeVueService;
	
	  @RequestMapping(value="api/TypeVue/all", method = RequestMethod.GET)
	    public List<TypeVue> getAllTypeVue(){
	        return typeVueService.findAll();
	    }
  
  @RequestMapping(value="api/TypeVue/save", method = RequestMethod.POST)
  public TypeVue saveTypeVue(
  		@RequestBody TypeVue typeVue){
  	return typeVueDao.save(typeVue);
  }
  
  
}

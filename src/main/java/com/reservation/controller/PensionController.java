package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.hotel.Pension;
import com.reservation.service.hotel.PensionService;
@CrossOrigin(origins = "*")
@RestController
public class PensionController {

	@Autowired
    private PensionService pensionService;

	  @RequestMapping(value="api/Pension/all", method = RequestMethod.GET)
	    public List<Pension> getAllPension(){
	        return pensionService.findAll();
	    }
	  
	  
}

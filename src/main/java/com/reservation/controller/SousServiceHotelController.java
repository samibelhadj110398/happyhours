package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.SousServiceHotelDao;
import com.reservation.model.hotel.SousServiceHotel;
import com.reservation.service.hotel.SousServiceHotelService;

@CrossOrigin(origins = "*")
@RestController
public class SousServiceHotelController {
	@Autowired
    private SousServiceHotelDao SousserviceHotelDao;
	@Autowired
    private SousServiceHotelService SousServiceHotelService;
	
	 @RequestMapping(value="api/SousServiceHotel/all", method = RequestMethod.GET)
	    public List<SousServiceHotel> listSousServiceHotel(){
	        return SousServiceHotelService.findAll();
	    }
	    
	    @RequestMapping(value="api/SousServiceHotel/save", method = RequestMethod.POST)
	    public SousServiceHotel saveSousServiceHotel(
	    		@RequestBody SousServiceHotel Sousservice){
	    	return SousserviceHotelDao.save(Sousservice);
	    }
}

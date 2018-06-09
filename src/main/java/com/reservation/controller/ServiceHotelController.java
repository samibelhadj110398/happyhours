package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.ServiceHotelDao;
import com.reservation.model.hotel.ServiceHotel;
import com.reservation.service.hotel.ServiceHotelService;

@CrossOrigin(origins = "*")
@RestController
public class ServiceHotelController {
	@Autowired
    private ServiceHotelDao serviceHotelDao;
	@Autowired
    private ServiceHotelService ServiceHotelService;
	
    @RequestMapping(value="api/ServiceHotel/all", method = RequestMethod.GET)
    public List<ServiceHotel> listServiceHotel(){
        return ServiceHotelService.findAll();
    }
    
    @RequestMapping(value="api/ServiceHotel/save", method = RequestMethod.POST)
    public ServiceHotel saveServiceHotel(
    		@RequestBody ServiceHotel service){
    	return serviceHotelDao.save(service);
    }
	
}

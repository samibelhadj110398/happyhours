package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.ServiceRestaurantDao;
import com.reservation.model.hotel.ServiceHotel;
import com.reservation.model.restaurant.ServiceRestaurant;
import com.reservation.service.restaurant.ServiceRestaurantService;

@CrossOrigin(origins = "*")
@RestController
public class ServiceRestaurantController {
	@Autowired
    private ServiceRestaurantDao serviceRestaurantDao;
	@Autowired
    private ServiceRestaurantService ServiceRestaurantService;
	
    @RequestMapping(value="api/ServiceRestaurant/all", method = RequestMethod.GET)
    public List<ServiceRestaurant> listServiceRestaurant(){
        return ServiceRestaurantService.findAll();
    }
    
    @RequestMapping(value="api/ServiceRestaurant/save", method = RequestMethod.POST)
    public ServiceRestaurant saveServiceRestaurant(
    		@RequestBody ServiceRestaurant service){
    	return serviceRestaurantDao.save(service);
    }
	
}

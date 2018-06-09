package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.DateDao;
import com.reservation.dao.RestaurantDao;
import com.reservation.model.DateModel;
import com.reservation.model.restaurant.Restaurant;

@CrossOrigin(origins = "*")
@RestController
public class DateController {
	@Autowired
    private DateDao dateDao;
	@Autowired
    private RestaurantDao restaurantDao;
	
	@RequestMapping(value="api/date/{id_restaurant}", method = RequestMethod.POST)
    public DateModel saveDate(
    		@PathVariable(value = "id_restaurant") Long id_restaurant,
    		@RequestBody DateModel dateModel){
    	Restaurant r =  restaurantDao.findOne(id_restaurant);
    	dateModel.setEtablissement(r);
    	return dateDao.save(dateModel);
    }
	
	
}

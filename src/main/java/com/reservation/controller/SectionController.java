package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.RestaurantDao;
import com.reservation.dao.SectionDao;
import com.reservation.model.restaurant.Menu;
import com.reservation.model.restaurant.Restaurant;
import com.reservation.model.restaurant.Section;


@CrossOrigin(origins = "*")
@RestController
public class SectionController {

	


	@Autowired
    private SectionDao sectionDao;
	@Autowired
    private RestaurantDao restaurantDao;
	
	@RequestMapping(value="api/Section/{id_restaurant}", method = RequestMethod.POST)
    public Section saveMenu(
    		@PathVariable(value = "id_restaurant") Long id_restaurant,
    		@RequestBody Section section){
    	Restaurant r =  restaurantDao.findOne(id_restaurant);
    	section.setRestaurant(r);
    	return sectionDao.save(section);
    }
}

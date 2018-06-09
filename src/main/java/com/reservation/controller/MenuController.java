package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.MenuDao;
import com.reservation.dao.RestaurantDao;
import com.reservation.model.restaurant.Menu;
import com.reservation.model.restaurant.Restaurant;


@CrossOrigin(origins = "*")
@RestController
public class MenuController {

	


	@Autowired
    private MenuDao menuDao;
	@Autowired
    private RestaurantDao restaurantDao;
	
	@RequestMapping(value="api/Menu/{id_restaurant}", method = RequestMethod.POST)
    public Menu saveMenu(
    		@PathVariable(value = "id_restaurant") Long id_restaurant,
    		@RequestBody Menu menu){
    	Restaurant r =  restaurantDao.findOne(id_restaurant);
    	menu.setRestaurant(r);
    	return menuDao.save(menu);
    }
}

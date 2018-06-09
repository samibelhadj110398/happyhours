package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.PromotionDao;
import com.reservation.dao.RestaurantDao;
import com.reservation.model.Promotion;
import com.reservation.model.restaurant.Restaurant;
import com.reservation.model.restaurant.Section;

@CrossOrigin(origins = "*")
@RestController
public class PromotionController {
	
	@Autowired
    private PromotionDao promotionDao;
	@Autowired
    private RestaurantDao restaurantDao;
	
	
	@RequestMapping(value="api/Promotion/{id_restaurant}", method = RequestMethod.POST)
    public Promotion savePromotion(
    		@PathVariable(value = "id_restaurant") Long id_restaurant,
    		@RequestBody Promotion promotion){
    	Restaurant r =  restaurantDao.findOne(id_restaurant);
    	promotion.setRestaurant(r);
    	return promotionDao.save(promotion);
    }

}

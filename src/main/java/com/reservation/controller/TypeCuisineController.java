package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.TypeCuisineDao;
import com.reservation.model.restaurant.ServiceRestaurant;
import com.reservation.model.restaurant.TypeCuisine;
import com.reservation.service.restaurant.ServiceRestaurantService;
import com.reservation.service.restaurant.TypeCuisineService;

@CrossOrigin(origins = "*")
@RestController
public class TypeCuisineController {
	@Autowired
    private TypeCuisineDao TypeCuisineDao;
	@Autowired
    private TypeCuisineService TypeCuisineService;
	
    @RequestMapping(value="api/TypeCuisine/all", method = RequestMethod.GET)
    public List<TypeCuisine> listTypeCuisine(){
        return TypeCuisineService.findAll();
    }
    
    @RequestMapping(value="api/TypeCuisine/save", method = RequestMethod.POST)
    public TypeCuisine saveTypeCuisine(
    		@RequestBody TypeCuisine typeCuisine){
    	return TypeCuisineDao.save(typeCuisine);
    }
	
}
package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.TypeCuisineDao;
import com.reservation.model.restaurant.ServiceRestaurant;
import com.reservation.model.restaurant.TypeCuisine;
import com.reservation.service.restaurant.TypeCuisineService;

@Service(value = "typeCuisineService")

public class TypeCuisineServiceImpl implements  TypeCuisineService {
	@Autowired
	private TypeCuisineDao typeCuisineDao;
	@Override
	public List<TypeCuisine> findAll() {
		List<TypeCuisine> list = new ArrayList<>();
		typeCuisineDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}

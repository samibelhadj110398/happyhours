package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.ServiceRestaurantDao;
import com.reservation.model.restaurant.ServiceRestaurant;
import com.reservation.service.restaurant.ServiceRestaurantService;

@Service(value = "serviceRestaurantService")

public class ServiceRestaurantServiceImpl implements  ServiceRestaurantService {
	@Autowired
	private ServiceRestaurantDao serviceRestaurantDao;
	@Override
	public List<ServiceRestaurant> findAll() {
		List<ServiceRestaurant> list = new ArrayList<>();
		serviceRestaurantDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}

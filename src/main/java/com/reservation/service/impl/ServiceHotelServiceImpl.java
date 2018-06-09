package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.ServiceHotelDao;
import com.reservation.model.hotel.ServiceHotel;
import com.reservation.service.hotel.ServiceHotelService;

@Service(value = "serviceHotelService")

public class ServiceHotelServiceImpl implements  ServiceHotelService {
	@Autowired
	private ServiceHotelDao serviceHotelDao;
	@Override
	public List<ServiceHotel> findAll() {
		List<ServiceHotel> list = new ArrayList<>();
		serviceHotelDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}

package com.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.HotelDao;
import com.reservation.service.hotel.HotelService;

@Service(value = "hotelService")

public class HotelServiceImpl implements  HotelService {

	
	@Autowired
	private HotelDao hotelDao;
}

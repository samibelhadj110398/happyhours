package com.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservation.model.hotel.SousServiceHotel;
import com.reservation.service.hotel.SousServiceHotelService;

@Service(value = "sousServiceHotelService")

public class SousServiceHotelServiceImpl implements  SousServiceHotelService {

	@Override
	public List<SousServiceHotel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

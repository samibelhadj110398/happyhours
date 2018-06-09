package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reservation.dao.TypeChambreDao;
import com.reservation.model.hotel.TypeChambre;
import com.reservation.model.restaurant.Plat;
import com.reservation.service.hotel.TypeChambreService;

@Service(value = "typeChambreServiceImpl")
public class TypeChambreServiceImpl implements  TypeChambreService{

	@Autowired
	private TypeChambreDao typeChambreDao;
	@Override
	public List<TypeChambre> findAll() {
		List<TypeChambre> list = new ArrayList<>();
		typeChambreDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


	
	
	
	
	
}

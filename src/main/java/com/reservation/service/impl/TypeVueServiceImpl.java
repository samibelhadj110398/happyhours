package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.TypeVueDao;
import com.reservation.model.hotel.TypeVue;
import com.reservation.service.hotel.TypeVueService;

@Service(value = "TypeVueServiceImpl")

public class TypeVueServiceImpl implements  TypeVueService {
	@Autowired
	private TypeVueDao sousCategorieDao;
	@Override
	public List<TypeVue> findAll() {
		List<TypeVue> list = new ArrayList<>();
		sousCategorieDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


}

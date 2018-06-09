package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.CategorieDao;
import com.reservation.model.Categorie;
import com.reservation.service.CategorieService;

@Service(value = "categorieService")
public class CategorieServiceImpl implements  CategorieService{

	@Autowired
	private CategorieDao categorieDao;


	@Override
	public List<Categorie> findAll() {
		List<Categorie> list = new ArrayList<>();
		categorieDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


}

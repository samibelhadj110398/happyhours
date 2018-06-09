package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.EquipementsGroupChambreDao;
import com.reservation.model.hotel.EquipementsGroupChambre;
import com.reservation.service.hotel.EquipementsGroupChambreService;

@Service(value = "equipementsCategorieHotelService")
public class EquipementsGroupChambreServiceImpl implements  EquipementsGroupChambreService{


	@Autowired
	private EquipementsGroupChambreDao equipementsCategorieHotelDao;
	@Override
	public List<EquipementsGroupChambre> findAll() {
		List<EquipementsGroupChambre> list = new ArrayList<>();
		equipementsCategorieHotelDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
}

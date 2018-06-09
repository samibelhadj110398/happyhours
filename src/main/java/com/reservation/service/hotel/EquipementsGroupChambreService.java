package com.reservation.service.hotel;

import java.util.List;

import com.reservation.dao.EquipementsGroupChambreDao;
import com.reservation.model.hotel.EquipementsGroupChambre;

public interface EquipementsGroupChambreService {
	//private EquipementsGroupChambreDao equipementsCategorieHotelDao;

	
	List<EquipementsGroupChambre> findAll();

}

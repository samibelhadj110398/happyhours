package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.hotel.EquipementsGroupChambre;

@Repository
public interface EquipementsGroupChambreDao extends CrudRepository<EquipementsGroupChambre, Long> {

}

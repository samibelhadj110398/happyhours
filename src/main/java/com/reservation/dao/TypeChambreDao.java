package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.hotel.TypeChambre;

@Repository
public interface TypeChambreDao extends CrudRepository<TypeChambre, Long> {

}

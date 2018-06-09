package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.hotel.SousServiceHotel;

@Repository
public interface SousServiceHotelDao extends CrudRepository<SousServiceHotel, Long> {

}

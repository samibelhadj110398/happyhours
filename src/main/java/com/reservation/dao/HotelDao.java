package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.hotel.Hotel;

@Repository

public interface HotelDao extends CrudRepository<Hotel, Long> {

}

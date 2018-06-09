package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.hotel.ServiceHotel;

@Repository

public interface ServiceHotelDao extends CrudRepository<ServiceHotel, Long> {

}

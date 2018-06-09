package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.restaurant.ServiceRestaurant;

@Repository

public interface ServiceRestaurantDao extends CrudRepository<ServiceRestaurant, Long> {

}

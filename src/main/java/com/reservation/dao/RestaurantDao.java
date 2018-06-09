package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.restaurant.Restaurant;

@Repository

public interface RestaurantDao extends CrudRepository<Restaurant, Long> {

}

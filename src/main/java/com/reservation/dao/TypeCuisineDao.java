package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.restaurant.TypeCuisine;

@Repository
public interface TypeCuisineDao extends CrudRepository<TypeCuisine, Long> {

}

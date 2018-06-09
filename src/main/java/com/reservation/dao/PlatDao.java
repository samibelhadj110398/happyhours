package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.restaurant.Plat;

@Repository

public interface PlatDao extends CrudRepository<Plat, Long> {

}

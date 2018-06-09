package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.hotel.Pension;

@Repository

public interface PensionDao extends CrudRepository<Pension, Long> {

}


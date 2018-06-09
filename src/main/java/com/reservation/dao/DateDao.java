package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.DateModel;

@Repository
public interface DateDao extends CrudRepository<DateModel, Long> {

}

package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.hotel.TypeVue;

@Repository
public interface TypeVueDao extends CrudRepository<TypeVue, Long> {

}
package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.restaurant.Section;

@Repository

public interface SectionDao extends CrudRepository<Section, Long> {

}

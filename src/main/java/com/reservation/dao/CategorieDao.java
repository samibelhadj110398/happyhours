package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Categorie;

@Repository
public interface CategorieDao extends CrudRepository<Categorie, Long> {

}
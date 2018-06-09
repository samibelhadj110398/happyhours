package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.utilisteur.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin, Long> {
    Admin findByUsername(String adminname);
}

package com.reservation.service.utilisateur;

import java.util.List;

import com.reservation.model.utilisteur.Admin;

public interface AdminService  {

    Admin save(Admin user);
    List<Admin> findAll();
    void delete(long id);
    Admin findOne(String username);

    Admin findById(Long id);
}

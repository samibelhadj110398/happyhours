package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.utilisteur.Agent;
import com.reservation.model.utilisteur.Client;

@Repository
public interface ClientDao extends CrudRepository<Client, Long> {
    Client findByClientname(String Clientname);
}

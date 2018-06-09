package com.reservation.service;

import java.util.List;

import com.reservation.model.Compte;

public interface CompteService {

	Compte save(Compte compte, Long id_agent);
	Compte saveClient(Compte compte, Long id_client);

    List<Compte> findAll();
    void delete(long id);

    Compte findById(Long id);
	Compte getCompte(Compte compte);
	boolean getCompteEmail(Compte compte);
}

package com.reservation.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reservation.model.Compte;

@Repository
public interface CompteDao extends CrudRepository<Compte, Long> {


	@Query("SELECT c FROM Compte c where c.username = ?1 AND c.password = ?2")
	Compte getCompte(String username, String password);
	
	@Query("SELECT c FROM Compte c where c.username = ?1")
	Compte getCompteEmail(String username);
	
	Compte findByUsername(String email);
	 Compte findByConfirmationToken(String confirmationToken);


}
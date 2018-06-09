package com.reservation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.model.Etablissement;

@Repository
public interface EtablissementDao extends CrudRepository<Etablissement, Long> {
	
	@Query("SELECT e FROM Etablissement e where e.id_agent = ?1")
	List<Etablissement> allEtablissementByAgent(Long id_agent);
	
	 @Transactional
	  @Modifying
	@Query("update Etablissement e set e.valide = true where e.id = :id")
	void valide(@Param("id") Long id );

	@Query("SELECT e FROM Etablissement e where e.id_agent = ?1 AND  e.valide = true")
	List<Etablissement> allEtablissementByAgentTrue(Long id);
	

	@Query("SELECT e FROM Etablissement e where e.id_agent = ?1 AND  e.valide = true AND e.id_cat = 1" )
	List<Etablissement> allRestaurantByAgentTrue(Long id);

	@Query("SELECT e FROM Etablissement e where e.valide = false")
	List<Etablissement> allEtablissementFalse();
	
	@Query("SELECT e FROM Etablissement e where e.valide = true")
	List<Etablissement> allEtablissementTrue();
	
	
}
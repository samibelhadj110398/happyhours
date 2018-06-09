package com.reservation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Etablissement;
import com.reservation.model.hotel.GroupeChambre;


	@Repository

	public interface GroupeChambreDao extends CrudRepository<GroupeChambre, Long> {

		
		@Query("SELECT e FROM GroupeChambre  e where e.hotel.id = ?1")
		List<GroupeChambre> getListChambreByIdEtab(Long id);		
		
	}
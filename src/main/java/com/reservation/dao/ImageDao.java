package com.reservation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Etablissement;
import com.reservation.model.Image;

@Repository

public interface ImageDao extends CrudRepository<Image, Long> {

	@Query("SELECT e.titre FROM Image  e where e.etablissement.id = ?1 ")
	List<String> allImageByEtab(Long id);
}

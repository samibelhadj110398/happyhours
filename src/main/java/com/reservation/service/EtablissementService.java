package com.reservation.service;

import java.util.List;

import com.reservation.model.Etablissement;
import com.reservation.model.hotel.Hotel;
import com.reservation.model.restaurant.Restaurant;

public interface EtablissementService {

	
	List<Etablissement> allEtablissementByAgent(Long id_agent);
	List<Etablissement> findAll();
	Etablissement findById(Long id);
	Etablissement update(long id, Etablissement etablissement);
	void valide(Long id);
	List<Etablissement> allEtablissementByAgentTrue(Long id);
	void delete(Long id);
	List<Etablissement> allRestaurantByAgentTrue(Long id);
	List<Etablissement> allEtablissementFalse();
	List<Etablissement> allEtablissementTrue();
	Long saveRestaurant(Restaurant etablissement, Long id_agent, Long id_categorie);
	Long saveHotel(Hotel h, Long id_agent, Long id_categorie);

    
}

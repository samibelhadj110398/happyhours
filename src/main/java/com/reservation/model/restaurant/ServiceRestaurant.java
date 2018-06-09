package com.reservation.model.restaurant;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ServiceRestaurant {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	 @ManyToMany(mappedBy = "serviceRestaurant")
	    private List<Restaurant> Restaurant ;

	@Column	    
		private String titre;

	public ServiceRestaurant(Long id, String titre) {
		super();
		this.id = id;
	
		this.titre = titre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public ServiceRestaurant() {
		super();
	}

	public List<Restaurant> getRestaurant() {
		return Restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		Restaurant = restaurant;
	}

	public ServiceRestaurant(Long id, List<com.reservation.model.restaurant.Restaurant> restaurant, String titre) {
		super();
		this.id = id;
		Restaurant = restaurant;
		this.titre = titre;
	}
	
	
	
}

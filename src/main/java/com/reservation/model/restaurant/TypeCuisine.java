package com.reservation.model.restaurant;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TypeCuisine {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	 
	@Column	    
	private String titre;

	@ManyToMany(mappedBy = "serviceRestaurant")
	private List<Restaurant> Restaurant ;

	public TypeCuisine(Long id, String titre, List<com.reservation.model.restaurant.Restaurant> restaurant) {
		super();
		this.id = id;
		this.titre = titre;
		Restaurant = restaurant;
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

	public List<Restaurant> getRestaurant() {
		return Restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		Restaurant = restaurant;
	}

	public TypeCuisine() {
		super();
	}
	
	

}

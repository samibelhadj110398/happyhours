package com.reservation.model.restaurant;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Section {

	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	 @Column	    
		private String titre;
	 
	 
	
	 
	@OneToMany
    private List<Plat> plat ;
	@ManyToOne
    private Restaurant restaurant ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTiter(String titre) {
		this.titre = titre;
	}
	
	public List<Plat> getPlat() {
		return plat;
	}
	public void setPlat(List<Plat> plat) {
		this.plat = plat;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Section(Long id, String titre, String description, List<Plat> plat, Restaurant restaurant) {
		super();
		this.id = id;
		this.titre = titre;
		this.plat = plat;
		this.restaurant = restaurant;
	}
	public Section() {
		super();
	}
	
	

	
	
	
	
}

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

public class Menu {

	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	 @Column	    
		private String titre;
	 @Column	    
		private String type;
	 @Column	    
		private String composition;
	 @Column	    
		private Integer  prix;
	 

	@ManyToOne
    private Restaurant restaurant ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTiter() {
		return titre;
	}
	public void setTiter(String titre) {
		this.titre = titre;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	public Menu(Long id, String titre, String type, String composition, Integer prix, Restaurant restaurant) {
		super();
		this.id = id;
		this.titre = titre;
		this.type = type;
		this.composition = composition;
		this.prix = prix;
		this.restaurant = restaurant;
	}
	public Menu() {
		super();
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	
	
	
	
}

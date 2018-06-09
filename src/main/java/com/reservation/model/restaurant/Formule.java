package com.reservation.model.restaurant;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Formule {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateD;
	 
	 @Column
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateF;
	 @ManyToOne
	    private Restaurant restaurant ;
	 @Column	    
		private String titre;
	 @Column	    
		private String description;
	 @Column	    
		private int nombreF;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNombreF() {
		return nombreF;
	}
	public void setNombreF(int nombreF) {
		this.nombreF = nombreF;
	}
	public Formule(Long id, Date dateD, Date dateF, Restaurant restaurant, String titre, String description,
			int nombreF) {
		super();
		this.id = id;
		this.dateD = dateD;
		this.dateF = dateF;
		this.restaurant = restaurant;
		this.titre = titre;
		this.description = description;
		this.nombreF = nombreF;
	}

	 
	 


}

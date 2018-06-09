package com.reservation.model;

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

import com.reservation.model.restaurant.Restaurant;

@Entity

public class Promotion {

	
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
	 
	 @Column
	 private Integer pourcentage;
	 
	 @ManyToOne
	    private Restaurant restaurant ;

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

	public Integer getPer() {
		return pourcentage;
	}

	public void setPer(Integer per) {
		this.pourcentage = per;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Promotion(Long id, Date dateD, Date dateF, Integer per, Restaurant restaurant) {
		super();
		this.id = id;
		this.dateD = dateD ;
		this.dateF = dateF;
		this.pourcentage = pourcentage;
		this.restaurant = restaurant;
	}

	public Promotion() {
		super();
	}

	public Integer getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(Integer pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	 
	 
	 
	 
	 
}

package com.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.reservation.model.hotel.GroupeChambre;
import com.reservation.model.hotel.Pension;

@Entity

public class Chambre_Pension {
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	 
	 @ManyToOne
	    private GroupeChambre chambre ;
	 @ManyToOne
	    private Pension pension ;
	 @Column
	    private Integer prix;
	public Chambre_Pension(Long id, GroupeChambre chambre, Pension pension, Integer prix) {
		super();
		this.id = id;
		this.chambre = chambre;
		this.pension = pension;
		this.prix = prix;
	}
	public Chambre_Pension() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public GroupeChambre getChambre() {
		return chambre;
	}
	public void setChambre(GroupeChambre chambre) {
		this.chambre = chambre;
	}
	public Pension getPension() {
		return pension;
	}
	public void setPension(Pension pension) {
		this.pension = pension;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	 
	 
}

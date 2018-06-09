package com.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.reservation.model.hotel.GroupeChambre;
@Entity

public class Image {
	
	    @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	 private Long id;
	 
	 @Column	    
		private String titre;
	 @ManyToOne
	    private Etablissement etablissement;
	 @ManyToOne
	    private GroupeChambre chambre;
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
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public Image() {
		super();
	}
	public GroupeChambre getChambre() {
		return chambre;
	}
	public void setChambre(GroupeChambre chambre) {
		this.chambre = chambre;
	}
	

	 
	 
}

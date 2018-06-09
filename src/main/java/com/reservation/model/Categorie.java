package com.reservation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Categorie {
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private long id;
	  @Column
	    private String nom;
	  @OneToMany(mappedBy="categorie" , cascade = CascadeType.ALL
	        )
	        private List<Etablissement> etablissement = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Etablissement> getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(List<Etablissement> etablissement) {
		this.etablissement = etablissement;
	}
	public Categorie(long id, String nom, List<Etablissement> etablissement) {
		super();
		this.id = id;
		this.nom = nom;
		this.etablissement = etablissement;
	}
	public Categorie() {
		super();
	}
	  
	  
}

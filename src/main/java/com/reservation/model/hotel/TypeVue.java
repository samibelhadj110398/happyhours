package com.reservation.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TypeVue {

	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;

	 
	
	 @OneToMany
	 private List<GroupeChambre> chambre ;
	 
	 
	 
	 
	 @Column
	 private String titre;
	 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeVue(Long id) {
		super();
		this.id = id;
	}

	public TypeVue() {
		super();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public TypeVue(Long id,  String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	
	 
}

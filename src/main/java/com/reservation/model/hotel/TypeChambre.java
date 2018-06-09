package com.reservation.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class TypeChambre {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	 @Column	    
	 private String titre;

	 @OneToMany
	 private List<GroupeChambre> chambre ;

	 
	 
	 
	public TypeChambre() {
		super();
	}

	public TypeChambre(Long id, String titre, double prix) {
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


	
	
	public TypeChambre(Long id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	
	

	 
	
	 
	 
}

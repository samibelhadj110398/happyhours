package com.reservation.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.reservation.model.Chambre_Pension;

@Entity

public class Pension {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column	    
	private String titre;
	
	
	@OneToMany
    private List<Chambre_Pension> chambre_Pension ;
	 

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

	


	public Pension(Long id, String titre, GroupeChambre chambre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	public Pension() {
		super();
	}



	public Pension(Long id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	
	}

	public List<Chambre_Pension> getChambre_Pension() {
		return chambre_Pension;
	}

	public void setChambre_Pension(List<Chambre_Pension> chambre_Pension) {
		this.chambre_Pension = chambre_Pension;
	}

	public Pension(Long id, String titre, List<Chambre_Pension> chambre_Pension) {
		super();
		this.id = id;
		this.titre = titre;
		this.chambre_Pension = chambre_Pension;
	}
	
	
}

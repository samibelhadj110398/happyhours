package com.reservation.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class EquipementsGroupChambre {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column	    
	 private String titre;


	 @ManyToMany(mappedBy = "equipementsGroupChambre")
	    private List<GroupeChambre> chambre ;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EquipementsGroupChambre(Long id) {
		super();
	}

	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	public EquipementsGroupChambre(Long id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}



	public EquipementsGroupChambre(Long id, String titre, boolean checked, List<GroupeChambre> chambre) {
		super();
		this.id = id;
		this.titre = titre;
		
		this.chambre = chambre;
	}

	public EquipementsGroupChambre() {
		super();
	}

	public List<GroupeChambre> getChambre() {
		return chambre;
	}

	public void setChambre(List<GroupeChambre> chambre) {
		this.chambre = chambre;
	}

	
	
	
	
}

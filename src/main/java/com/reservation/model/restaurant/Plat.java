package com.reservation.model.restaurant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Plat {
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	 	@Column	    
		private String titre;
	 	@Column	    
		private String description;
	 	@Column	    
		private Integer prix;
	
	 
	 @ManyToOne
	    private Section section;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTiter() {
		return titre;
	}

	public void setTiter(String titer) {
		this.titre = titer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	

	public Plat(Long id, String titre, String description, Integer prix) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
	}

	public Plat() {
		super();
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	 
	
	
	 
	 

}

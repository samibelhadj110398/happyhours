package com.reservation.model.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class SousServiceHotel {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column	    
	private String titre;
	
 	@ManyToOne
    private ServiceHotel serviceHotel ;
 	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SousServiceHotel(Long id) {
		super();
		this.id = id;
	}

	public SousServiceHotel() {
		super();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public ServiceHotel getServiceHotel() {
		return serviceHotel;
	}

	public void setServiceHotel(ServiceHotel serviceHotel) {
		this.serviceHotel = serviceHotel;
	}

	public SousServiceHotel(Long id, String titre, ServiceHotel serviceHotel) {
		super();
		this.id = id;
		this.titre = titre;
		this.serviceHotel = serviceHotel;
	}
	
}

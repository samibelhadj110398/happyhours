package com.reservation.model.hotel;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.reservation.model.Categorie;
import com.reservation.model.Etablissement;
import com.reservation.model.Image;
import com.reservation.model.utilisteur.Agent;

@Entity
@DiscriminatorValue("Ho")

public class Hotel extends Etablissement{
	
	 
	 
	@OneToMany
    private List<GroupeChambre> chambre ;
	
	@Column	    
	private Integer nombreEtoile ;
	@Column	    
	private boolean  internet ;
	@OneToMany
	 private List<Hotel_Categorie> hotel_Categorie ;
	 
	@OneToMany
    private List<Image> images ;
	@Column
	private Integer nombreHebergement;

	 @ManyToMany(cascade = { 
		        CascadeType.PERSIST, 
		        CascadeType.MERGE
		    })
		    @JoinTable(name = "hotel_service",
		        joinColumns = @JoinColumn(name = "hotel_id"),
		        inverseJoinColumns = @JoinColumn(name = "service_id")
		    )
		    private List<ServiceHotel> serviceHotel ;
	 
	//@Column
	//private int[] array pensions ;
	
	
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(Long id, String nom, String paye, String region, String adresse,
			 Integer tel, String site, String facebook, String description,
			Long id_agent, Long id_cat, boolean valide, Time heureO, Time heureF, Agent agent, Categorie categorie) {
		super(id, nom, paye, region, adresse, tel, site, description, id_agent,
				id_cat, valide, heureO, heureF, agent, categorie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}
	

	

	public Integer getNombreEtoile() {
		return nombreEtoile;
	}

	public void setNombreEtoile(Integer nombreEtoile) {
		this.nombreEtoile = nombreEtoile;
	}

	public Integer getNombreHebergement() {
		return nombreHebergement;
	}

	public void setNombreHebergement(Integer nombreHebergement) {
		this.nombreHebergement = nombreHebergement;
	}

	public List<GroupeChambre> getChambre() {
		return chambre;
	}

	public void setChambre(List<GroupeChambre> chambre) {
		this.chambre = chambre;
	}


	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public boolean getInternet() {
		return internet;
	}

	public void setInternet(boolean internet) {
		this.internet = internet;
	}

	public Hotel(List<GroupeChambre> chambre, Integer nombreEtoile, boolean internet,
			List<Hotel_Categorie> hotel_Categorie, List<Image> images, Integer nombreHebergement,
			List<ServiceHotel> serviceHotel) {
		super();
		this.chambre = chambre;
		this.nombreEtoile = nombreEtoile;
		this.internet = internet;
		this.hotel_Categorie = hotel_Categorie;
		this.images = images;
		this.nombreHebergement = nombreHebergement;
		this.serviceHotel = serviceHotel;
	}

	public List<Hotel_Categorie> getHotel_Categorie() {
		return hotel_Categorie;
	}

	public void setHotel_Categorie(List<Hotel_Categorie> hotel_Categorie) {
		this.hotel_Categorie = hotel_Categorie;
	}

	public List<ServiceHotel> getServiceHotel() {
		return serviceHotel;
	}

	public void setServiceHotel(List<ServiceHotel> serviceHotel) {
		this.serviceHotel = serviceHotel;
	}



	
	
	
	

}

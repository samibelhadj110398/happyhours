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
public class ServiceHotel {

	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;

	 @ManyToMany(mappedBy = "serviceHotel")
	    private List<Hotel> Hotel ;

	 
	 	@Column	    
		private String titre;
	 	@OneToMany
	    private List<SousServiceHotel> sousServiceHotel ;

	public List<SousServiceHotel> getSousServiceHotel() {
			return sousServiceHotel;
		}

		public void setSousServiceHotel(List<SousServiceHotel> sousServiceHotel) {
			this.sousServiceHotel = sousServiceHotel;
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

	public ServiceHotel(Long id, String titre, List<SousServiceHotel> sousServiceHotel) {
		super();
		this.id = id;
		this.titre = titre;
		this.sousServiceHotel = sousServiceHotel;
	}

	

	public ServiceHotel() {
		super();
	}
	 

}

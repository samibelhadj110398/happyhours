package com.reservation.model.hotel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.reservation.model.Chambre_Pension;
import com.reservation.model.Image;

@Entity

public class GroupeChambre {

	
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	
	 @OneToMany
	    private List<Chambre_Pension> chambre_Pension ;
	
		 @OneToMany
		    private List<GroupeChambreDisponibilite> groupeChambreDisp ;
	 @Column
	 private double surface;
		@ManyToOne
	    private Hotel hotel ;
		
		@ManyToOne
	    private  TypeChambre typeChambre ;
		@ManyToOne
	    private  TypeVue typeVue ;
		
		 @ManyToMany(cascade = { 
			        CascadeType.PERSIST, 
			        CascadeType.MERGE
			    })
			    @JoinTable(name = "Ch_eq",
			        joinColumns = @JoinColumn(name = "Ch_id"),
			        inverseJoinColumns = @JoinColumn(name = "eq_id")
			    )
			    private List<EquipementsGroupChambre> equipementsGroupChambre ;
		 
		 
		
		
		
		
	   public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

		public List<Image> getImages() {
			return images;
		}

		public void setImages(List<Image> images) {
			this.images = images;
		}

	@OneToMany
	     private List<Image> images ;
	  
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public GroupeChambre() {
		super();
	}




	public List<Chambre_Pension> getChambre_Pension() {
		return chambre_Pension;
	}

	public void setChambre_Pension(List<Chambre_Pension> chambre_Pension) {
		this.chambre_Pension = chambre_Pension;
	}

	public TypeChambre getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}


	public TypeVue getTypeVue() {
		return typeVue;
	}

	public void setTypeVue(TypeVue typeVue) {
		this.typeVue = typeVue;
	}

	public List<EquipementsGroupChambre> getEquipementsGroupChambre() {
		return equipementsGroupChambre;
	}

	public void setEquipementsGroupChambre(List<EquipementsGroupChambre> equipementsGroupChambre) {
		this.equipementsGroupChambre = equipementsGroupChambre;
	}

	public List<GroupeChambreDisponibilite> getGroupeChambreDisp() {
		return groupeChambreDisp;
	}

	public void setGroupeChambreDisp(List<GroupeChambreDisponibilite> groupeChambreDisp) {
		this.groupeChambreDisp = groupeChambreDisp;
	}


	
	
	 
}

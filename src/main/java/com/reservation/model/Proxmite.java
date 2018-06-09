package com.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Proxmite {
	
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	 	@Column	    
		private String nom;
	 	@Column	 
	 	private Double distance;	 	
	 	 @ManyToOne
		    private Etablissement etablissement;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public Double getDistance() {
			return distance;
		}
		public void setDistance(Double distance) {
			this.distance = distance;
		}
		public Etablissement getEtablissement() {
			return etablissement;
		}
		public void setEtablissement(Etablissement etablissement) {
			this.etablissement = etablissement;
		}
		public Proxmite(Long id, String nom, Double distance, Etablissement etablissement) {
			super();
			this.id = id;
			this.nom = nom;
			this.distance = distance;
			this.etablissement = etablissement;
		}
		public Proxmite() {
			super();
		}
	 	

}

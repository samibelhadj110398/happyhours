package com.reservation.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.reservation.model.restaurant.Deal;
import com.reservation.model.utilisteur.Agent;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_etab",discriminatorType=DiscriminatorType.STRING,length=2)
//@JsonDeserialize(as = Restaurant.class)


public   class Etablissement implements Serializable {

	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	    @Column
	    
	private String nom;
	    @Column
	private String ville;
	    
	    @Column
		private String email;
	    
	    @Column
	private String adresse;
	  
	    @Column
	private Integer tel;
	    
	   
	    @Column
	private String site;
	   
	    @Column
	private String description;
	    @Column
		private Long id_agent;
	    @Column
	  		private Long id_cat;
	    @Column
		private boolean valide;
	    @OneToMany
	     private List<Image> images ;
	    @OneToMany
	     private List<Proxmite> proxmite ;
	    @OneToMany
	     private List<DateModel> horaire ;
		 @Column	    
			private double latitude;
		 @Column	    
			private double longitude;
		 
		 
	    
	   
	    
	    @JsonFormat(pattern = "hh:mm:ss")
	    @Column()
	    private java.sql.Time heureO;
	    @JsonFormat(pattern = "hh:mm:ss")
	    @Column()
	    private java.sql.Time heureF;
	    
	    
	   
	    
		    

	    @ManyToOne
		 private Agent agent;

	    @ManyToOne
		 private Categorie categorie;    
	    
	    @OneToMany
	     private List<Deal> deal ;
	    
	    
	    
		public List<Image> getImages() {
			return images;
		}

		public void setImages(List<Image> images) {
			this.images = images;
		}

		public List<Deal> getDeal() {
			return deal;
		}

		public void setDeal(List<Deal> deal) {
			this.deal = deal;
		}

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

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		

		public Integer getTel() {
			return tel;
		}

		public void setTel(Integer tel) {
			this.tel = tel;
		}

		

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}

		

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		@JsonIgnore
		public Agent getAgent() {
			return agent;
		}

		public void setAgent(Agent agent) {
			this.agent = agent;
		}

		

		
		@JsonIgnore
		public Categorie getCategorie() {
			return categorie;
		}

		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}

	
		public Etablissement() {
			super();
		}

	

		public Long getId_agent() {
			return id_agent;
		}

		public void setId_agent(Long id_agent) {
			this.id_agent = id_agent;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Time getHeureO() {
			return heureO;
		}

		public void setHeureO(Time heureO) {
			this.heureO = heureO;
		}

		public Time getHeureF() {
			return heureF;
		}

		public void setHeureF(Time heureF) {
			this.heureF = heureF;
		}

		public boolean isValide() {
			return valide;
		}

		public void setValide(boolean valide) {
			this.valide = valide;
		}

		public Long getId_cat() {
			return id_cat;
		}

		public void setId_cat(Long id) {
			this.id_cat = id;
		}

		public Etablissement(Long id, String nom, String ville, String email, String adresse,
				 Integer tel, String site, String description,
				Long id_agent, Long id_cat, boolean valide, Time heureO, Time heureF, Agent agent,
				Categorie categorie) {
			super();
			this.id = id;
			this.nom = nom;
			this.ville = ville;
			this.email = email;
			this.adresse = adresse;
			this.tel = tel;
			this.site = site;
			this.description = description;
			this.id_agent = id_agent;
			this.id_cat = id_cat;
			this.valide = valide;
			this.heureO = heureO;
			this.heureF = heureF;
			this.agent = agent;
			this.categorie = categorie;
		}
		
		public String getType() {
			return null;
		}
		public void setType(String type) {
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		public List<DateModel> getHoraire() {
			return horaire;
		}

		public void setHoraire(List<DateModel> horaire) {
			this.horaire = horaire;
		}

		public List<Proxmite> getProxmite() {
			return proxmite;
		}

		public void setProxmite(List<Proxmite> proxmite) {
			this.proxmite = proxmite;
		}

		
		
		

	
	

	
}

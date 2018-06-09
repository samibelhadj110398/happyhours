package com.reservation.model.restaurant;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.reservation.model.Categorie;
import com.reservation.model.Etablissement;
import com.reservation.model.Promotion;
import com.reservation.model.utilisteur.Agent;

@Entity
@DiscriminatorValue("Re")

public class Restaurant extends Etablissement{
	
	 	@Column	    
		private String type;
	 	
	 	 @OneToMany
	     private List<Menu> menu ;
	  @OneToMany
	     private List<Section> section ;
	  @OneToMany
	     private List<Promotion> promotions ;
	  @Column
	     private String carte ;
	  
	 
	  @Column
	  private Integer fourchette_prix ;
	  
	  @Column
	  private Integer nombre_couverts;
	  
	  @Column
	  private String[] fonctionnalite;
	  @Column
	  private String type_restaurant;
	  
	  @Column
	  private String[] typecuisine;
	  
	
		 @ManyToMany(cascade = { 
			        CascadeType.PERSIST, 
			        CascadeType.MERGE
			    })
			    @JoinTable(name = "restaurant_service",
			        joinColumns = @JoinColumn(name = "restaurant_id"),
			        inverseJoinColumns = @JoinColumn(name = "service_id")
			    )
			    private List<ServiceRestaurant > serviceRestaurant ;
	

	

	public Restaurant(String type, List<Menu> menu, List<Section> section, List<Promotion> promotions, String carte,
				Integer fourchette_prix, Integer nombre_couverts, String[] fonctionnalite, String type_restaurant,
				String[] typecuisine, List<ServiceRestaurant> serviceRestaurant) {
			super();
			this.type = type;
			this.menu = menu;
			this.section = section;
			this.promotions = promotions;
			this.carte = carte;
			this.fourchette_prix = fourchette_prix;
			this.nombre_couverts = nombre_couverts;
			this.fonctionnalite = fonctionnalite;
			this.type_restaurant = type_restaurant;
			this.typecuisine = typecuisine;
			this.serviceRestaurant = serviceRestaurant;
		}

	public List<ServiceRestaurant> getServiceRestaurant() {
			return serviceRestaurant;
		}

		public void setServiceRestaurant(List<ServiceRestaurant> serviceRestaurant) {
			this.serviceRestaurant = serviceRestaurant;
		}

	public String[] getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(String[] fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

	public String[] getTypecuisine() {
		return typecuisine;
	}

	public void setTypecuisine(String[] typecuisine) {
		this.typecuisine = typecuisine;
	}

	public Restaurant() {
		super();
	}

	public Restaurant(Long id, String nom, String paye, String region, String adresse,
			 Integer tel, String site, String facebook, String description,
			Long id_agent, Long id_cat, boolean valide, Time heureO, Time heureF, Agent agent, Categorie categorie) {
		super(id, nom, paye, region, adresse, tel, site, description, id_agent,
				id_cat, valide, heureO, heureF, agent, categorie);
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	public List<Section> getSection() {
		return section;
	}

	public void setSection(List<Section> section) {
		this.section = section;
	}

	public String getCarte() {
		return carte;
	}

	public void setCarte(String carte) {
		this.carte = carte;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}



	public Integer getFourchette_prix() {
		return fourchette_prix;
	}

	public void setFourchette_prix(Integer fourchette_prix) {
		this.fourchette_prix = fourchette_prix;
	}

	public Integer getNombre_couverts() {
		return nombre_couverts;
	}

	public void setNombre_couverts(Integer nombre_couverts) {
		this.nombre_couverts = nombre_couverts;
	}

	
	
	public String getType_restaurant() {
		return type_restaurant;
	}

	public void setType_restaurant(String type_restaurant) {
		this.type_restaurant = type_restaurant;
	}


	public Restaurant(String type, List<Menu> menu, List<Section> section, List<Promotion> promotions, String carte,
			Integer fourchette_prix, Integer nombre_couverts, String[] fonctionnalite, String type_restaurant,
			String[] typecuisine) {
		super();
		this.type = type;
		this.menu = menu;
		this.section = section;
		this.promotions = promotions;
		this.carte = carte;
		this.fourchette_prix = fourchette_prix;
		this.nombre_couverts = nombre_couverts;
		this.fonctionnalite = fonctionnalite;
		this.type_restaurant = type_restaurant;
		this.typecuisine = typecuisine;
		
	}


	
	
	

	

	
	
}

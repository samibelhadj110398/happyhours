package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.AgentDao;
import com.reservation.dao.CategorieDao;
import com.reservation.dao.GroupeChambreDao;
import com.reservation.dao.EtablissementDao;
import com.reservation.dao.HotelDao;
import com.reservation.dao.PensionDao;
import com.reservation.model.Bar;
import com.reservation.model.Beaute;
import com.reservation.model.Categorie;
import com.reservation.model.Etablissement;
import com.reservation.model.hotel.GroupeChambre;
import com.reservation.model.hotel.Hotel;
import com.reservation.model.hotel.Pension;
import com.reservation.model.restaurant.Restaurant;
import com.reservation.model.utilisteur.Agent;
import com.reservation.service.EtablissementService;


@Service(value = "etablissementService")
public class EtablissementServiceImpl implements  EtablissementService{

	@Autowired
	private EtablissementDao etablissementDao;
	@Autowired
	private AgentDao agentDao;
	@Autowired
	private CategorieDao categorieDao;
	@Autowired
	private PensionDao pensionDao;
	@Autowired
	private GroupeChambreDao chambreDao;
	@Autowired
	private HotelDao hotelDao;
	
	
	@Override
	public Long saveRestaurant(Restaurant etablissement,Long id_agent,Long id_categorie) {
		Long i = null ;
			Restaurant newEtablissement = new Restaurant();
			
			    newEtablissement.setCarte("Carte de "+etablissement.getNom());			 
			    newEtablissement.setType(etablissement.getType());
				newEtablissement.setNom(etablissement.getNom());
				newEtablissement.setVille(etablissement.getVille());
				newEtablissement.setAdresse(etablissement.getAdresse());
				newEtablissement.setDescription(etablissement.getDescription());
				newEtablissement.setSite(etablissement.getSite());
				newEtablissement.setTel(etablissement.getTel());
				newEtablissement.setEmail(etablissement.getEmail());
				newEtablissement.setHeureO(etablissement.getHeureO());
				newEtablissement.setHeureF(etablissement.getHeureF());
				newEtablissement.setLatitude(etablissement.getLatitude());
				newEtablissement.setLongitude(etablissement.getLongitude());


				newEtablissement.setType_restaurant(etablissement.getType_restaurant());
				newEtablissement.setFourchette_prix(etablissement.getFourchette_prix());
				newEtablissement.setNombre_couverts(etablissement.getNombre_couverts());
				newEtablissement.setType_restaurant(etablissement.getType_restaurant());
				newEtablissement.setFonctionnalite(etablissement.getFonctionnalite());
				newEtablissement.setTypecuisine(etablissement.getTypecuisine());

				newEtablissement.setValide(false);		
				Agent a = new Agent();
		    	a=agentDao.findOne(id_agent);
		    	newEtablissement.setId_agent(a.getId());
		    	Categorie c = new Categorie();
		    	c=categorieDao.findOne(id_categorie);
		    	newEtablissement.setId_cat(c.getId());
		    	newEtablissement.setAgent(a);
		    	newEtablissement.setCategorie(c);
		    	 i = etablissementDao.save(newEtablissement).getId();

		
		return i;
    	
	}


	@Override
	public List<Etablissement> allEtablissementByAgent(Long id_agent) {
		return etablissementDao.allEtablissementByAgent(id_agent);

	}
	


	@Override
	public List<Etablissement> findAll() {
		List<Etablissement> list = new ArrayList<>();
		etablissementDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


	@Override
	public Etablissement findById(Long id) {
		return etablissementDao.findOne(id);

	}


	@Override
	public Etablissement update(long id, Etablissement etablissement) {
		  Etablissement e = etablissementDao.findOne(id);	
		  etablissementDao.delete(e.getId());
		  e=etablissement;
	      //this.saveR(etablissement, etablissement.getId_agent(), etablissement.getCategorie().getId());
	      return e;
	}


	@Override
	public void valide(Long id) {
		 etablissementDao.valide(id);
	}


	@Override
	public List<Etablissement> allEtablissementByAgentTrue(Long id) {
		return etablissementDao.allEtablissementByAgentTrue(id);
	}


	@Override
	public void delete(Long id) {
		etablissementDao.delete(id);
		
	}


	@Override
	public List<Etablissement> allRestaurantByAgentTrue(Long id) {
		return etablissementDao.allRestaurantByAgentTrue(id);

	}


	@Override
	public List<Etablissement> allEtablissementFalse() {
		return etablissementDao.allEtablissementFalse();

	}


	@Override
	public List<Etablissement> allEtablissementTrue() {
		return etablissementDao.allEtablissementTrue();

	}


	/*@Override
	public Long saveHotel(Hotel etablissement,Long id_agent,Long id_categorie) {
		Long i = null ;
			Hotel hotel = new Hotel();
			
		    List<Chambre> chambress = new ArrayList<Chambre>();
	    	 etablissementDao.save(hotel);

	    	List<Chambre> chambres =  etablissement.getChambre();	    	
	    	for(Chambre chambre : chambres) {  
	    		List<Pension> pensions = chambre.getPension();	
	    		Chambre ch = new Chambre();
	    		ch.setNom(chambre.getNom());
	    		ch.setEquipements(chambre.getEquipements());
	    		ch.setSupplement_single(chambre.getSupplement_single());
	    		ch.setSurface(chambre.getSurface());
	    		ch.setTypeHebergement(chambre.getTypeHebergement());
	    		//ch.setHotel(hotel);
	    		chambreDao.save(ch);
	    		chambress.add(ch);
		    	for(Pension pension : pensions){
			    	System.out.println(pension.getPrix());
			    	pension.setChambre(ch);			    	
			    	pensionDao.save(pension);

			    	
		    	}
		    	//ch.setPension(pensions);
	    		chambreDao.save(ch);

	    	}	    	
	    	hotel.setType(etablissement.getType());
	    	hotel.setNom(etablissement.getNom());
	    	hotel.setVille(etablissement.getVille());
	    	hotel.setAdresse(etablissement.getAdresse());
	    	hotel.setDescription(etablissement.getDescription());
	    	hotel.setSite(etablissement.getSite());
	    	hotel.setTel(etablissement.getTel());
	    	hotel.setEmail(etablissement.getEmail());
	    	hotel.setHeureO(etablissement.getHeureO());
	    	hotel.setHeureF(etablissement.getHeureF());
	    	hotel.setLatitude(etablissement.getLatitude());
	    	hotel.setLongitude(etablissement.getLongitude());


	    	hotel.setEquipement(etablissement.getEquipement());
	    	hotel.setNombreEtoile(etablissement.getNombreEtoile());
	    	hotel.setNombreHebergement(etablissement.getNombreHebergement());
	    	hotel.setValide(false);	
				Agent a = new Agent();
		    	a=agentDao.findOne(id_agent);
		    	hotel.setId_agent(a.getId());
		    	Categorie c = new Categorie();
		    	c=categorieDao.findOne(id_categorie);
		    	hotel.setId_cat(c.getId());
		    	hotel.setAgent(a);
		    	hotel.setCategorie(c);
		    	hotel.setChambre(chambress);
		    	
		    	 i = etablissementDao.save(hotel).getId();

		    	 
		
		return i;
    	
	}
*/
	@Override
	public Long saveHotel(Hotel etablissement,Long id_agent,Long id_categorie) {
		Long i = null ;
			Hotel hotel = new Hotel();
			
	    	 etablissementDao.save(hotel);
	    	
	    	hotel.setType(etablissement.getType());
	    	hotel.setNom(etablissement.getNom());
	    	hotel.setVille(etablissement.getVille());
	    	hotel.setAdresse(etablissement.getAdresse());
	    	hotel.setDescription(etablissement.getDescription());
	    	hotel.setSite(etablissement.getSite());
	    	hotel.setTel(etablissement.getTel());
	    	hotel.setEmail(etablissement.getEmail());
	    	hotel.setHeureO(etablissement.getHeureO());
	    	hotel.setHeureF(etablissement.getHeureF());
	    	hotel.setLatitude(etablissement.getLatitude());
	    	hotel.setLongitude(etablissement.getLongitude());


	    
	    	hotel.setNombreEtoile(etablissement.getNombreEtoile());
	    	hotel.setNombreHebergement(etablissement.getNombreHebergement());
	    	hotel.setValide(false);	
				Agent a = new Agent();
		    	a=agentDao.findOne(id_agent);
		    	hotel.setId_agent(a.getId());
		    	Categorie c = new Categorie();
		    	c=categorieDao.findOne(id_categorie);
		    	hotel.setId_cat(c.getId());
		    	hotel.setAgent(a);
		    	hotel.setCategorie(c);
		    	
		    	i = etablissementDao.save(hotel).getId();

		    	 
		
		return i;
    	
	}



	



}

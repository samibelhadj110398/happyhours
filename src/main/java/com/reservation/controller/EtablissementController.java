package com.reservation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.reservation.dao.AgentDao;
import com.reservation.dao.CategorieDao;
import com.reservation.dao.EtablissementDao;
import com.reservation.model.Categorie;
import com.reservation.model.Etablissement;
import com.reservation.model.Image;
import com.reservation.model.hotel.GroupeChambre;
import com.reservation.model.hotel.Hotel;
import com.reservation.model.restaurant.Restaurant;
import com.reservation.model.utilisteur.Agent;
import com.reservation.service.EtablissementService;
import com.reservation.service.impl.EmailService;
import com.reservation.service.impl.SendEmail;
import com.reservation.service.impl.StorageService;

@CrossOrigin(origins = "*")
@RestController
public class EtablissementController {
	@Autowired
	StorageService storageService;
	 @Autowired
	    SendEmail serviceSendEmail;
	 @Autowired
	    private EtablissementService etablissementService;
		@Autowired
		private AgentDao agentDao;
		@Autowired
		private CategorieDao categorieDao;
		@Autowired
		private EtablissementDao etablissementDao;
		@Autowired
		private EmailService emailService;
		
		
	    @RequestMapping(value="api/Etablissement/all", method = RequestMethod.GET)
	    public List<Etablissement> listEtablissement(){
	        return etablissementService.findAll();
	    }

	   
	 
	    
	    
	    @RequestMapping(value="api/Etablissement/getImages/{id}", method = RequestMethod.GET)
	    public List<Image> allEtabImage(@PathVariable(value = "id") Long id){
	    	Etablissement e =  etablissementDao.findOne(id);
	    	
	    	return e.getImages();
	    }
	    
	    
	    
	    @RequestMapping(value="api/Etablissement/{id_agent}/{id_categorie}", method = RequestMethod.POST)
	    public Long saveEtablissement(
	    		@PathVariable(value = "id_agent") Long id_agent,
	    		@PathVariable(value = "id_categorie") Long id_categorie,
	    		@RequestBody Restaurant etab){	
	    	System.out.println("f");
	    		return etablissementService.saveRestaurant(etab,id_agent,id_categorie);

	    	
	    }
	    
	    @RequestMapping(value="api/Etablissement/Hotel/{id_agent}/{id_categorie}", method = RequestMethod.POST)
	    public Long saveEtablissementHotel(
	    		@PathVariable(value = "id_agent") Long id_agent,
	    		@PathVariable(value = "id_categorie") Long id_categorie,
	    		@RequestBody Hotel etab){	
	    	

    		return etablissementService.saveHotel(etab,id_agent,id_categorie);

	    	
	    }
	    
	 
	    @RequestMapping(value="api/Etablissement/allEtablissementByAgent/{id}", method = RequestMethod.GET)
	    public List<Etablissement> allEtablissementByAgent(@PathVariable(value = "id") Long id){
	    	
	    	return etablissementService.allEtablissementByAgent(id);
	    }
	    
	    @RequestMapping(value="api/Etablissement/allEtablissementByAgentTrue/{id}", method = RequestMethod.GET)
	    public List<Etablissement> allEtablissementByAgentTrue(@PathVariable(value = "id") Long id){
	    	
	    	return etablissementService.allEtablissementByAgentTrue(id);
	    }
	    
	    
	    @RequestMapping(value = "api/Etablissement/{id}", method = RequestMethod.GET)
	    public Etablissement getOne(@PathVariable(value = "id") Long id){
	        return etablissementService.findById(id);
	    }
	    
	 
	  
	   
	    
	    @RequestMapping(value="api/Etablissement/update/{id}/{id_agent}/{id_categorie}", method = RequestMethod.POST)
	    public Etablissement update(
	    		@PathVariable(value = "id") Long id,
	    		@PathVariable(value = "id_agent") Long id_agent,
	    		@PathVariable(value = "id_categorie") Long id_categorie,
	    		@RequestBody Etablissement etablissement){
	    	//etablissement.setValide(true);
	    	
	    	etablissement.setId(id);
	    	Agent a = new Agent();
	    	a=agentDao.findOne(id_agent);
	    	etablissement.setId_agent(a.getId());
	    	Categorie c = new Categorie();
	    	c=categorieDao.findOne(id_categorie);
	    	etablissement.setId_cat(c.getId());

	    	etablissement.setAgent(a);
	    	etablissement.setCategorie(c);
	    	etablissement.setValide(true);
	    	
	    	return etablissementDao.save(etablissement);
	    }
	   
	    
	    @RequestMapping(value="api/Etablissement/valide/{id}", method = RequestMethod.POST)
	    public void saveEtablissement(
	    		@PathVariable(value = "id") Long id){
	    	
	    	 etablissementService.valide(id);
	    }
	    
	    @RequestMapping(value = "api/Etablissement/delet/{id}", method = RequestMethod.DELETE)
	  		public boolean delete(@PathVariable("id") Long id) {
	    	etablissementService.delete(id);
	  			return true;
	  		}
	    
	    @RequestMapping(value="api/Etablissement/allRestaurantByAgentTrue/{id}", method = RequestMethod.GET)
	    public List<Etablissement> allRestaurantByAgentTrue(@PathVariable(value = "id") Long id){
	    	
	    	return etablissementService.allRestaurantByAgentTrue(id);
	    }
	    
	    
	    
	    @RequestMapping(value="api/Etablissement/allEtablissementFalse/", method = RequestMethod.GET)
	    public List<Etablissement> allEtablissementFalse(){
	    	
	    	return etablissementService.allEtablissementFalse();
	    }
	    
	    @RequestMapping(value="api/Etablissement/allEtablissementTrue/", method = RequestMethod.GET)
	    public List<Etablissement> allEtablissementTrue(){
	    	
	    	return etablissementService.allEtablissementTrue();
	    }
	    
	  
	    
	   
	    @RequestMapping(value="api/agent/send/{id}", method = RequestMethod.POST)
	    public String send(
	    		@PathVariable(value = "id") Long id){
	        
	    	Agent a = new Agent();
	    	
	    	Etablissement e = etablissementService.findById(id);
	    	a = e.getAgent();
		    // serviceSendEmail.sendSimpleMessage(a.getMail(), "", "Votre établissement "+e.getNom()+" a été enregistrée");

		        SimpleMailMessage registrationEmail = new SimpleMailMessage();
				registrationEmail.setTo(a.getMail());

				registrationEmail.setSubject("Etablissement information");
				registrationEmail.setText("Votre établissement "+e.getNom()+" a été enregistrée");
				registrationEmail.setFrom("contact@happyhours.tn");
				emailService.sendEmail(registrationEmail);
				return "ok";
		        
	    }
	    
	    
	    @GetMapping("api/Etab/getallfiles/{id}")
		public ResponseEntity<List<String>> getListFiles(Model model,@PathVariable(value = "id") Long id) {
	    	List<String> files = new ArrayList<String>();

	    	Etablissement e =  etablissementDao.findOne(id);
	    	List<Image> ListImages= new ArrayList<Image>();
	    	ListImages = e.getImages();
	    	for (Image img : ListImages) {
	    		String string = img.getTitre();	
	   		    String[] parts = string.split("/");
	   		    String part1 = parts[0]; 
	   		    String filename = parts[1]; 
	    		files.add(filename);
	    	}
			List<String> fileNames = files
					.stream().map(fileName -> MvcUriComponentsBuilder
							.fromMethodName(UploadController.class, "getFile", fileName).build().toString())
					.collect(Collectors.toList());
	 
			return ResponseEntity.ok().body(fileNames);
		}
	    
	    
	    @GetMapping("api/Etab/files/{filename:.+}")
		@ResponseBody
		public ResponseEntity<Resource> getFile(@PathVariable String filename) {
			Resource file = storageService.loadFile(filename);
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
					.body(file);
		}
	  
	    
	    
	    
	    
}
	    
	    
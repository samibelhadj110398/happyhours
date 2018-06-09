package com.reservation.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.CompteDao;
import com.reservation.model.Compte;
import com.reservation.service.CompteService;
import com.reservation.service.impl.EmailService;
import com.reservation.service.utilisateur.AgentService;

@CrossOrigin(origins = "*")
@RestController
public class CompteController {
	 @Autowired
		private EmailService emailService;
	 @Autowired
	    private CompteService CompteService;
	 @Autowired
	    private AgentService agentService;
	 @Autowired
	    private CompteDao compteDao;
	    @RequestMapping(value="api/Compte", method = RequestMethod.GET)
	    public List<Compte> listCompte(){
	        return CompteService.findAll();
	    }

	    @RequestMapping(value = "api/Compte/{id}", method = RequestMethod.GET)
	    public Compte getOne(@PathVariable(value = "id") Long id){
	        return CompteService.findById(id);
	    }
	    
	    @RequestMapping(value="api/CompteSave/{id_agent}", method = RequestMethod.POST)
	    public Compte saveCompte(@PathVariable(value = "id_agent") Long id_agent,@RequestBody Compte Compte){
	    	
	    	return CompteService.save(Compte,id_agent);
	    }
	    @RequestMapping(value="api/CompteSaveClient/{id_client}", method = RequestMethod.POST)
	    public Compte saveCompteClient(@PathVariable(value = "id_client") Long id_client,@RequestBody Compte Compte){
	    	
	    	return CompteService.saveClient(Compte,id_client);
	    }
	    
	    @RequestMapping(value="api/getCompte", method = RequestMethod.POST)
	    public Compte saveCompte(@RequestBody Compte Compte){
	    	
	    	return CompteService.getCompte(Compte);
	    }
	    @RequestMapping(value="api/getCompteEmail", method = RequestMethod.POST)
	    public boolean getCompteEmail(@RequestBody Compte Compte){
	    	
	    	return CompteService.getCompteEmail(Compte);
	    }  
	    
	    @RequestMapping(value="api/CompteUpdateCompte/{id_compte}", method = RequestMethod.POST)
	    public Compte update(
	    		@PathVariable(value = "id_compte") Long id_compte,
	    		@RequestBody Compte compte){    	
	    	Compte c = new Compte();    	
	    	c.setId(id_compte);
	    	c.setPassword(compte.getPassword());
	    	c.setUsername(compte.getUsername());    	
	    	
	    	return compteDao.save(c);
	    }
	    
	    @RequestMapping(value="api/user/confirm/{token}", method = RequestMethod.GET)
		public Compte confirmRegistration( @PathVariable(value = "token") String token) {
				String ch;
				String ch2 = null;
			Compte compte = compteDao.findByConfirmationToken(token);
				
			if (compte == null) { 
				ch = "invalidToken  Oops!  This is an invalid confirmation link.";
				return null;		

			} else { 
				ch = "confirmationToken"+ compte.getConfirmationToken();
				Compte comptex = compteDao.findByConfirmationToken(token);
				comptex.setEnabled(true);
				compteDao.save(comptex);
				ch2 = "successMessage !";
				return comptex;		

			}
				
		}
	    
	    
	    
		
		@RequestMapping(value="api/CompteUpdatePassword/{id_compte}", method = RequestMethod.POST)
	    public Compte updatePassword(
	    		@PathVariable(value = "id_compte") Long id_compte,
	    		@RequestBody Compte compte){        	 	
	    	
	    	 Compte compteModifer=compteDao.findOne(id_compte);
	    	 compteModifer.setPassword(compte.getPassword());
	    	 compteModifer.setUsername(compte.getUsername());
	    	return compteDao.save(compteModifer);
	    }
		@RequestMapping(value="api/CompteUpdateNPassword/{token}", method = RequestMethod.POST)
	    public Compte updateNPassword(
	    		@PathVariable(value = "token") String token,
	    		@RequestBody Compte compte){        	 	
	    	
	    	 Compte compteModifer=compteDao.findByConfirmationToken(token);
	    	 compteModifer.setPassword(compte.getPassword());

	    	 compteModifer.setConfirmationToken(UUID.randomUUID().toString());
	    	return compteDao.save(compteModifer);
	    }
		
		
		
		@RequestMapping(value="api/CompteOublieMotPasse/{email:.+}", method = RequestMethod.GET)
	    public Compte CompteOublieMotPasse(
	    		@PathVariable(value = "email") String email
	    		){       
			Compte compteExists = compteDao.findByUsername(email);
			if (compteExists != null) {
			
				SimpleMailMessage registrationEmail = new SimpleMailMessage();
				registrationEmail.setTo(compteExists.getUsername());
				registrationEmail.setSubject("Récupérer votre mot de passe");
				registrationEmail.setText("Bonjour "+compteExists.getAgent().getAgentname()+"\n  Nous avons reçu une demande de réinitialisation de votre mot de passe."
						+ "Cliquez sur le lien ci-dessous pour récupérer votre mot de passe :\n"
						+ "http://happyhours.tn" + "/NmotPasse/" + compteExists.getConfirmationToken() +"\n"
								+ "Si vous n'étes pas à l'origine de cette demande,veuillez ignorer "
						
						);
				registrationEmail.setFrom("contact@happyhours.tn");
				emailService.sendEmail(registrationEmail);
			}			
	    	return compteExists;	
	    }
	    
		
		@RequestMapping(value="api/getToken/{token}", method = RequestMethod.GET)
		public boolean getToken( @PathVariable(value = "token") String token) {
				boolean test;
			Compte compte = compteDao.findByConfirmationToken(token);
				
			if (compte == null) { 				
				test = false;	
			} else { 
				test = true;
			}
			return test;				
		}
	    
}

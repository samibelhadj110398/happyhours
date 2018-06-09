package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reservation.dao.AgentDao;
import com.reservation.dao.ClientDao;
import com.reservation.dao.CompteDao;
import com.reservation.model.Compte;
import com.reservation.model.utilisteur.Agent;
import com.reservation.model.utilisteur.Client;
import com.reservation.service.CompteService;

@Service(value = "compteService")
public class CompteServiceImpl implements CompteService{

	@Autowired
	private EmailService emailService;
	@Autowired
	private CompteDao compteDao;
	@Autowired
	private AgentDao agentDao;
	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Compte save(Compte compte,Long id_agent) {
		String ch = "";

		Compte compteExists = compteDao.findByUsername(compte.getUsername());
		System.out.println(compteExists);
		
		if (compteExists != null) {
			ch = "alreadyRegisteredMessage Oops!  There is already a user registered with the email provided.";
		}
		else { 
			
			compte.setEnabled(false);
		      
			compte.setConfirmationToken(UUID.randomUUID().toString());
			Agent a = new Agent();
	    	a=agentDao.findOne(id_agent);
	    	compte.setAgent(a);
			compteDao.save(compte);
				
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(compte.getUsername());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("Pour confirmer votre adresse e-mail,"
					+ " cliquez sur le lien ci-dessous:\n"
					+ "http://happyhours.tn" + "/confirm/" + compte.getConfirmationToken());
			registrationEmail.setFrom("contact@happyhours.tn");
			
			emailService.sendEmail(registrationEmail);
			
			ch = "confirmationMessage A confirmation e-mail has been sent to " + compte.getUsername();
		}
		
		
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> list = new ArrayList<>();
		compteDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		compteDao.delete(id);
		
	}

	@Override
	public Compte findById(Long id) {
		return compteDao.findOne(id);

	}

	@Override
	public Compte getCompte(Compte compte) {
		String nom = compte.getUsername();
		String password = compte.getPassword();
		Compte c =compteDao.getCompte(nom,password);
		if (c!=null && c.isEnabled()){
			return c;
		}else{
			return null;
		}
	}
	
	@Override
	public boolean getCompteEmail(Compte compte) {
		String nom = compte.getUsername();
		Compte c =compteDao.getCompteEmail(nom);
		if (c!=null && c.isEnabled()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Compte saveClient(Compte compte, Long id_client) {
		
		String ch = "";
		Compte compteExists = compteDao.findByUsername(compte.getUsername());
		System.out.println(compteExists);
		if (compteExists != null) {
			ch = "alreadyRegisteredMessage Oops!  There is already a user registered with the email provided.";
		}	else { 			
			compte.setEnabled(false);		      
			compte.setConfirmationToken(UUID.randomUUID().toString());
			
	    	Client c = new Client();
	    	c = clientDao.findOne(id_client);
	    	compte.setClient(c);
	    	compteDao.save(compte);				
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(compte.getUsername());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("Pour confirmer votre adresse e-mail,"
					+ " cliquez sur le lien ci-dessous:\n"
					+ "http://happyhours.tn" + "/confirm/" + compte.getConfirmationToken());
			registrationEmail.setFrom("contact@happyhours.tn");
			
			emailService.sendEmail(registrationEmail);
			
			ch = "confirmationMessage A confirmation e-mail has been sent to " + compte.getUsername();
		}
		
		
		
		
		
		
		return compte;
	}
	
	
	
	
}

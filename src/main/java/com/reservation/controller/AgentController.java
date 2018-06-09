package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.AgentDao;
import com.reservation.dao.CompteDao;
import com.reservation.model.Compte;
import com.reservation.model.utilisteur.Agent;
import com.reservation.service.impl.SendEmail;
import com.reservation.service.utilisateur.AgentService;

@CrossOrigin(origins = "*")
@RestController
public class AgentController {

	 @Autowired
	    private AgentService agentService;
	 @Autowired
	    SendEmail serviceSendEmail;
	 @Autowired
		private CompteDao compteDao;
	 @Autowired
		private AgentDao agentDao;
	 
	    @RequestMapping(value="api/agent", method = RequestMethod.GET)
	    public List<Agent> listAgent(){
	        return agentService.findAll();
	    }

	    @RequestMapping(value = "api/agent/{id}", method = RequestMethod.GET)
	    public Agent getOne(@PathVariable(value = "id") Long id){
	        return agentService.findById(id);
	    }
	    
	    @RequestMapping(value="api/AgentSignup", method = RequestMethod.POST)
	    public Agent saveAgent(@RequestBody Agent agent){
	    	return agentService.save(agent);
	    }
	    @RequestMapping(value = "api/deleteAgent/{id}", method = RequestMethod.DELETE)
		public boolean delete(@PathVariable("id") Long id) {
	    	agentService.delete(id);
			return true;
		}
	    
	    
		@RequestMapping(value="api/CompteUpdateAgent/{id_agent}/{id_compte}", method = RequestMethod.POST)
	    public Agent update(
	    		@PathVariable(value = "id_agent") Long id_agent,
	    		@PathVariable(value = "id_compte") Long id_compte,
	    		@RequestBody Agent agent){    	
	    	Agent a = new Agent();    	
	    	a.setId(id_agent);
	    	a.setAgentname(agent.getAgentname());
	    	a.setMail(agent.getMail());
	    	a.setPrenom(agent.getPrenom());
	    	a.setTel(agent.getTel());   	
	    	
	    	Compte compte = new Compte();
	    	compte=compteDao.findOne(id_compte);
	    	compte.setUsername(agent.getMail());
	    	compteDao.save(compte);
	    	return agentDao.save(a);
	    }
		
		
	
	    
	  
	    
}

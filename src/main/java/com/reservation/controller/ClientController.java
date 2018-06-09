package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.ClientDao;
import com.reservation.dao.CompteDao;
import com.reservation.model.Compte;
import com.reservation.model.utilisteur.Client;
import com.reservation.service.utilisateur.ClientService;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
	@Autowired
    private ClientService clientService;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private CompteDao compteDao;
	
	@RequestMapping(value="api/client", method = RequestMethod.GET)
    public List<Client> listClient(){
        return clientService.findAll();
    }
	
	@RequestMapping(value = "api/client/{id}", method = RequestMethod.GET)
    public Client getOne(@PathVariable(value = "id") Long id){
        return clientService.findById(id);
    }
	
	@RequestMapping(value="api/ClientSignup", method = RequestMethod.POST)
    public Client saveClient(@RequestBody Client client){
    	return clientService.save(client);
    }
	
	@RequestMapping(value = "api/deleteClient/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") Long id) {
    	clientService.delete(id);
		return true;
	}
	
	
	
	@RequestMapping(value="api/CompteUpdateClient/{id_client}/{id_compte}", method = RequestMethod.POST)
    public Client update(
    		@PathVariable(value = "id_client") Long id_client,
    		@PathVariable(value = "id_compte") Long id_compte,
    		@RequestBody Client client){    	
    	Client c = new Client();    	
    	c.setId(id_client);
    	c.setClientname(client.getClientname());
    	c.setEmail(client.getEmail());
    	c.setPrenom(client.getPrenom());
    	c.setTel(client.getTel());   	
    	
    	Compte compte = new Compte();
    	compte=compteDao.findOne(id_compte);
    	compte.setUsername(client.getEmail());
    	compteDao.save(compte);
    	return clientDao.save(c);
    }

	
	
	
}

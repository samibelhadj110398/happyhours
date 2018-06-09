package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.AgentDao;
import com.reservation.dao.ClientDao;
import com.reservation.dao.CompteDao;
import com.reservation.model.utilisteur.Agent;
import com.reservation.model.utilisteur.Client;
import com.reservation.service.utilisateur.ClientService;

@Service(value = "clientService")

public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private CompteDao compteDao;

	@Override
	public Client save(Client client) {
		Client newClient = new Client();
		newClient.setPrenom(client.getPrenom());
		newClient.setClientname(client.getClientname());		
		newClient.setTel(client.getTel());
		newClient.setEmail(client.getEmail());
		return clientDao.save(newClient);
	}
	
	

	@Override
	public List<Client> findAll() {
		List<Client> list = new ArrayList<>();
		clientDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		clientDao.delete(id);
		
	}

	@Override
	public Client findOne(String Clientname) {
		return clientDao.findByClientname(Clientname);

	}

	@Override
	public Client findById(Long id) {
		return clientDao.findOne(id);

	}
	
	
}

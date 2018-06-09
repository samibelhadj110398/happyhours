package com.reservation.service.utilisateur;

import java.util.List;

import com.reservation.model.utilisteur.Client;

public interface ClientService {

	
	Client save(Client client);
    List<Client> findAll();
    void delete(long id);
    Client findOne(String Clientname);

    Client findById(Long id);
    
    
}

package com.reservation.service.utilisateur;

import java.util.List;

import com.reservation.model.utilisteur.Agent;

public interface AgentService {

	
	Agent save(Agent agent);
    List<Agent> findAll();
    void delete(long id);
    Agent findOne(String Agentname);

    Agent findById(Long id);
    
}

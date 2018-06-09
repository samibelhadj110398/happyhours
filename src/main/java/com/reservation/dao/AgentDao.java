package com.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.utilisteur.Agent;

@Repository
public interface AgentDao extends CrudRepository<Agent, Long> {
    Agent findByAgentname(String Agentname);

	Agent findByMail(String mail);
}
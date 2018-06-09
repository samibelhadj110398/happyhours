package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.AgentDao;
import com.reservation.model.Compte;
import com.reservation.model.utilisteur.Agent;
import com.reservation.service.utilisateur.AgentService;

@Service(value = "agentService")
public class AgentServiceImpl implements  AgentService{

	@Autowired
	private AgentDao agentDao;
	@Override
	public Agent save(Agent agent) {
		
		Agent agentExists = agentDao.findByMail(agent.getMail());
		if(agentExists ==null){
		Agent newAgent = new Agent();
		newAgent.setFonction(agent.getFonction());
		newAgent.setPrenom(agent.getPrenom());
		newAgent.setTel(agent.getTel());
		newAgent.setAgentname(agent.getAgentname());
		newAgent.setMail(agent.getMail());
		newAgent.setValide(false);
		return agentDao.save(newAgent);
		}else {
			return null;
		}
		
		
	}

	@Override
	public List<Agent> findAll() {
		List<Agent> list = new ArrayList<>();
		agentDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		agentDao.delete(id);
		
	}

	@Override
	public Agent findOne(String Agentname) {
		return agentDao.findByAgentname(Agentname);

	}

	@Override
	public Agent findById(Long id) {
		return agentDao.findOne(id);

	}

}

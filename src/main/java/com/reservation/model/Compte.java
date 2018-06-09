package com.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.reservation.model.utilisteur.Agent;
import com.reservation.model.utilisteur.Client;

@Entity
public class Compte {
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private long id;
	  @Column
	    private String username;
	    @Column
	    //@JsonIgnore
	    private String password;
	    
	    @Column
		private boolean enabled;
	    
		@Column
		private String confirmationToken;
	    
	 @ManyToOne
	 private Agent agent;
	 @ManyToOne
	 private Client client;
	 
	 

	    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

		public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

		public Agent getAgent() {
			return agent;
		}

		public void setAgent(Agent agent) {
			this.agent = agent;
		}

		public Compte(long id, Agent agent) {
			super();
			this.id = id;
			this.agent = agent;
		}

		public Compte() {
			super();
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Compte(long id, String username, String password, Agent agent) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.agent = agent;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public String getConfirmationToken() {
			return confirmationToken;
		}

		public void setConfirmationToken(String confirmationToken) {
			this.confirmationToken = confirmationToken;
		}
		
		
	    
	    
}

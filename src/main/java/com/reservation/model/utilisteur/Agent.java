package com.reservation.model.utilisteur;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.reservation.model.Etablissement;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String agentname;
    @Column
    private String prenom;
    @Column
    private String fonction;
    @Column
    private Integer tel;
    @Column
    private String mail;
    @Column
    private boolean valide;
    
    @OneToMany(mappedBy="agent",cascade = CascadeType.ALL)
        private List<Etablissement> etablissement = new ArrayList<>();
    @OneToMany(mappedBy="agent",cascade = CascadeType.ALL)

   
	

	

	

	public List<Etablissement> getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(List<Etablissement> etablissement) {
		this.etablissement = etablissement;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public String getMail() {
        return mail;
    }

    public void setMail(String Mail) {
        this.mail = Mail;
    }

	public Agent(long id, String agentname, String mail) {
		super();
		this.id = id;
		this.agentname = agentname;
		this.mail = mail;
	}

	public Agent() {
		super();
	}
    

}
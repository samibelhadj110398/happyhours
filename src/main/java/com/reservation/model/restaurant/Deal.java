package com.reservation.model.restaurant;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.reservation.model.Etablissement;

@Entity

public class Deal {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateD;
	 
	 @Column
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateF;
	 @ManyToOne
	    private Etablissement etablissement ;
	 @Column	    
		private String titre;
	 @Column	    
		private String description;
	 @Column	    
		private int nombreD;


	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNombreD() {
		return nombreD;
	}
	public void setNombreD(int nombreD) {
		this.nombreD = nombreD;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Deal(Long id, Date dateD, Date dateF, Etablissement etablissement, String titre, String description,
			int nombreD) {
		super();
		this.id = id;
		this.dateD = dateD;
		this.dateF = dateF;
		this.etablissement = etablissement;
		this.titre = titre;
		this.description = description;
		this.nombreD = nombreD;
	}
	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	 
}

package com.reservation.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DateModel {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
	 @Column	    
		private String  jour;
	 @JsonFormat(pattern = "hh:mm")
	 @Temporal(TemporalType.TIMESTAMP )
	 @Column
	  private Date  journeeO;

     
     @JsonFormat(pattern = "hh:mm")
     @Temporal(TemporalType.TIMESTAMP )
     
	 @Column
	 private Date  journeeF;
	 
     @JsonFormat(pattern = "hh:mm")
     @Temporal(TemporalType.TIMESTAMP )
	 @Column
	 private Date  soirO;
	 
     
     @JsonFormat(pattern = "hh:mm")
     @Temporal(TemporalType.TIMESTAMP )
	 @Column
	 private Date  soirF;
     
     @ManyToOne
	 private Etablissement etablissement;

	public DateModel(long id, String jour, Date journeeO, Date journeeF, Date soirO, Date soirF) {
		super();
		this.id = id;
		this.jour = jour;
		this.journeeO = journeeO;
		this.journeeF = journeeF;
		this.soirO = soirO;
		this.soirF = soirF;
	}

	public DateModel() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Date getJourneeO() {
		return journeeO;
	}

	public void setJourneeO(Date journeeO) {
		this.journeeO = journeeO;
	}

	public Date getJourneeF() {
		return journeeF;
	}

	public void setJourneeF(Date journeeF) {
		this.journeeF = journeeF;
	}

	public Date getSoirO() {
		return soirO;
	}

	public void setSoirO(Date soirO) {
		this.soirO = soirO;
	}

	public Date getSoirF() {
		return soirF;
	}

	public void setSoirF(Date soirF) {
		this.soirF = soirF;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	
	
	 
	 
	 

}

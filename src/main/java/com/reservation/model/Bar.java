package com.reservation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@DiscriminatorValue("Ba")

public class Bar extends Etablissement{

	@Column	    
	private String type;
	
	
	@Override
	public String getType() {
		return null;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

package com.reservation.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

	@Entity
	@DiscriminatorValue("Be")

	public class Beaute extends Etablissement{

		@Override
		public String getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setType(String type) {
			// TODO Auto-generated method stub
			
		}
		
}

package com.reservation.model.hotel;

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

@Entity

public class GroupeChambreDisponibilite {
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
		private Long id;
	
	 @Column
	 private Integer nombreChambreDisp;
	 @Column 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private Date dateDisp;
		@ManyToOne
	    private  GroupeChambre groupeChambre ;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getNombreChambreDisp() {
			return nombreChambreDisp;
		}
		public void setNombreChambreDisp(Integer nombreChambreDisp) {
			this.nombreChambreDisp = nombreChambreDisp;
		}
		public Date getDateDisp() {
			return dateDisp;
		}
		public void setDateDisp(Date dateDisp) {
			this.dateDisp = dateDisp;
		}
		public GroupeChambre getGroupeChambre() {
			return groupeChambre;
		}
		public void setGroupeChambre(GroupeChambre groupeChambre) {
			this.groupeChambre = groupeChambre;
		}
		public GroupeChambreDisponibilite(Long id, Integer nombreChambreDisp, Date dateDisp, GroupeChambre groupeChambre) {
			super();
			this.id = id;
			this.nombreChambreDisp = nombreChambreDisp;
			this.dateDisp = dateDisp;
			this.groupeChambre = groupeChambre;
		}
		public GroupeChambreDisponibilite() {
			super();
		}
	 
}

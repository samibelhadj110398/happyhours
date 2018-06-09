package com.reservation.model.utilisteur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private long id;
	    @Column
	    private String clientname;
	    @Column
	    private String prenom;
	    @Column
	    private Integer tel;
	    @Column
	    private String email;
	    
	    
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getClientname() {
			return clientname;
		}
		public void setClientname(String clientname) {
			this.clientname = clientname;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public Integer getTel() {
			return tel;
		}
		public void setTel(Integer tel) {
			this.tel = tel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Client(long id, String clientname, String prenom, Integer tel, String email) {
			super();
			this.id = id;
			this.clientname = clientname;
			this.prenom = prenom;
			this.tel = tel;
			this.email = email;
		}
		public Client() {
			super();
		}
	    
	    
}

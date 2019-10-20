package com.usjt.beehealthy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="patient") @DiscriminatorValue("P")
public class Patient extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idPatient;
	public Double weight;
	public Double height;
	public String description;
	
	//@OneToOne
	//@JoinColumn(name="id_user")
	public User user;
	
	public int getIdPatient() {
		return idPatient;
	}
	
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
		
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Double getHeight() {
		return height;
	}
	
	public void setHeight(Double height) {
		this.height = height;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}

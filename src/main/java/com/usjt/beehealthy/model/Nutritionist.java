package com.usjt.beehealthy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity @Table(name="nutritionist")
@PrimaryKeyJoinColumn(name="idUser")
public class Nutritionist extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idNutritionist;
	@NotNull(message="Specialization is required.")
	public String specialization;
	@NotNull(message="CRN is required.")
	public String crn;
	@Transient
	public User user;

	public int getIdNutritionist() {
		return idNutritionist;
	}

	public void setIdNutritionist(int idNutritionist) {
		this.idNutritionist = idNutritionist;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}

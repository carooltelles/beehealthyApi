package com.usjt.beehealthy.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity @Table(name="nutritionist") @DiscriminatorValue("N")
public class Nutritionist extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idNutritionist;
	@NotNull(message="Specialization is required.")
	public String specialization;
	@NotNull(message="CRN is required.")
	public String crn;
	
	//@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="id_user")
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

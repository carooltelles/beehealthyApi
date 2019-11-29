package com.usjt.beehealthy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity @Table(name="nutritionist")
@PrimaryKeyJoinColumn(name="iduser")
public class Nutritionist extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String specialization;
	public String crn;
	public String address;
		
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
}

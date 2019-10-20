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
	
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	public Long idnutritionist;
	@NotNull(message="Specialization is required.")
	public String specialization;
	@NotNull(message="CRN is required.")
	public String crn;

//	public Long getIdNutritionist() {
//		return idnutritionist;
//	}
//
//	public void setIdNutritionist(Long idnutritionist) {
//		this.idnutritionist = idnutritionist;
//	}

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

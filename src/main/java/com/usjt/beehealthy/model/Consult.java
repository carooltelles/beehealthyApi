package com.usjt.beehealthy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "consult")
@Inheritance(strategy = InheritanceType.JOINED)
public class Consult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idconsult;
	@NotNull(message = "Place is required.")
	private String place;
	@NotNull(message = "String is required.")
	private String date;
	@ManyToOne(optional=false)
    @JoinColumn(name = "idnutritionist",nullable=false)
	private Nutritionist nutritionist;
	@ManyToOne(optional=false)
    @JoinColumn(name = "idpatient",nullable=false)
	private Patient patient;

	public Long getIdconsult() {
		return idconsult;
	}

	public void setIdconsult(Long idconsult) {
		this.idconsult = idconsult;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Nutritionist getNutritionist() {
		return nutritionist;
	}

	public void setNutritionist(Nutritionist nutritionist) {
		this.nutritionist = nutritionist;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Consult [idconsult=" + idconsult + ", place=" + place + ", String=" + date + ", nutritionist="
				+ nutritionist + ", patient=" + patient + "]";
	}
}

package com.usjt.beehealthy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="nutritionistclient")
public class NutritionistClient implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idclient;
	
	@ManyToOne(optional=false)
    @JoinColumn(name = "idnutritionist",nullable=false)
	public Nutritionist nutritionist;
	@ManyToOne(optional=false)
    @JoinColumn(name = "idpatient",nullable=false)
	public Patient patient;

		
	public Long getIdclient() {
		return idclient;
	}
	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Nutritionist getNutritionist() {
		return nutritionist;
	}
	public void setNutritionist(Nutritionist nutritionist) {
		this.nutritionist = nutritionist;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

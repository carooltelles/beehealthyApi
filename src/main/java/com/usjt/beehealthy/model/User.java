package com.usjt.beehealthy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;;


@Entity @Table(name="user") @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int idUser;	
	@NotNull(message="Email is required.")
	public String email;
	@NotNull(message="Password is required.")
	public String password;
	@NotNull
	public String fullname;
	public Date birthday;
	@NotNull(message="Type is required.")
	public String type;

	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getEmail() { 
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}

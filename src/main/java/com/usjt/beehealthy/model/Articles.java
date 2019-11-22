package com.usjt.beehealthy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="articles")
public class Articles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idarticle;
	@ManyToOne(optional=false)
	@JoinColumn(name = "idnutritionist", nullable=false)
	public Nutritionist idnutritionist;
	public String title;
	public String text;
	
	
	public Long getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(Long idarticle) {
		this.idarticle = idarticle;
	}
	public Nutritionist getIdnutritionist() {
		return idnutritionist;
	}
	public void setIdnutritionist(Nutritionist idnutritionist) {
		this.idnutritionist = idnutritionist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}

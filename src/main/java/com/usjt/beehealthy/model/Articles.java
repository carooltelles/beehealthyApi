package com.usjt.beehealthy.model;

import javax.persistence.Column;
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
	@JoinColumn(name = "nutritionist", nullable=false)
	public Nutritionist nutritionist;
	public String title;
	@Column(columnDefinition = "LONGTEXT")
	public String text;
	
	public Articles (String title, String text, Nutritionist nutritionist) {
		this.title = title;
		this.text = text;
		this.nutritionist = nutritionist;
	}
	
	public Articles (Long idarticle, String title, String text, Nutritionist nutritionist) {
		this.idarticle = idarticle;
		this.title = title;
		this.text = text;
		this.nutritionist = nutritionist;
	}
	
	public Articles() {
		
	}
	
	
	public Long getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(Long idarticle) {
		this.idarticle = idarticle;
	}
	public Nutritionist getnutritionist() {
		return nutritionist;
	}
	public void setnutritionist(Nutritionist nutritionist) {
		this.nutritionist = nutritionist;
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

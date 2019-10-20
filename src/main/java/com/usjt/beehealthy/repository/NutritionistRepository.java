package com.usjt.beehealthy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.Nutritionist;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
	public Nutritionist findByiduser(Long id);
	
	public Nutritionist findByTypeAndEmail(String type, String email);
	
	public Nutritionist deleteByiduser(Long id);
}

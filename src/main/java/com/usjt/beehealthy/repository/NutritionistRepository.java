package com.usjt.beehealthy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.Nutritionist;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Long> {
	public Nutritionist findByUser(int userId);
}

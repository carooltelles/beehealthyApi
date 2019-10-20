package com.usjt.beehealthy.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.repository.NutritionistRepository;

public class NutritionistService {

	@Autowired
	NutritionistRepository nutritionistRepository;
	
	public Nutritionist registerNutritionist(Nutritionist nutritionist) {
		return nutritionistRepository.save(nutritionist);
	}
}

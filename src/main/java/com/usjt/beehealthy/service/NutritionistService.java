package com.usjt.beehealthy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.repository.NutritionistRepository;
import com.usjt.beehealthy.repository.UserRepository;

@Service
public class NutritionistService {

	@Autowired
	NutritionistRepository nutritionistRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Nutritionist> findAllNutritionist() {
		try {
			return nutritionistRepository.findAll();
		}catch(Exception e) {
			throw e;
		}
	}

	public Nutritionist findNutritionist(Long userId) {
		try {
			return nutritionistRepository.findByiduser(userId);			
		}catch(Exception e) {
			throw e;
		}
	}
	
	public Nutritionist updateNutritionist(Long userId, Nutritionist nutritionist) {
		try {
			Nutritionist updatedNutritionist = nutritionistRepository.findByiduser(userId);
			updatedNutritionist.setCrn(nutritionist.getCrn());
			updatedNutritionist.setEmail(nutritionist.getEmail());
			updatedNutritionist.setPassword(nutritionist.getPassword());
			updatedNutritionist.setSpecialization(nutritionist.getSpecialization());
			updatedNutritionist.setType(nutritionist.getType());
			return updatedNutritionist;

		}catch(Exception e) {
			throw e;
		}
	}
	
	
	public void deleteNutritionist(Long userId) {
		try {
			nutritionistRepository.deleteById(userId);			
		}catch(Exception e) {
			throw e;
		}
	}
}

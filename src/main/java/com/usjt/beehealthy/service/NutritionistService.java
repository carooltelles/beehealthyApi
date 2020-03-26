package com.usjt.beehealthy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
	
	public Nutritionist updateNutritionist(Long userId, Nutritionist nutritionist) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

			ObjectNode userJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(nutritionist));
			Nutritionist updatedNutritionist = nutritionistRepository.findByiduser(userId);
			updatedNutritionist.setCrn(nutritionist.getCrn());
			updatedNutritionist.setFullname(nutritionist.getFullname());
			updatedNutritionist.setBirthday(nutritionist.getBirthday());
			updatedNutritionist.setEmail(nutritionist.getEmail());
			updatedNutritionist.setAddress(nutritionist.getAddress());
			updatedNutritionist.setPassword(nutritionist.getPassword());
			updatedNutritionist.setSpecialization(nutritionist.getSpecialization());
			updatedNutritionist.setType(nutritionist.getType());
			return updatedNutritionist;
	}
	
	
	public void deleteNutritionist(Long userId) {
		try {
			nutritionistRepository.deleteById(userId);			
		}catch(Exception e) {
			throw e;
		}
	}

	public List<Nutritionist> findNutritionistByName(String fullname) {
		try {
			return nutritionistRepository.findByFullnameContaining(fullname);
		}catch(Exception e) {
			throw e;
		}
	}
}

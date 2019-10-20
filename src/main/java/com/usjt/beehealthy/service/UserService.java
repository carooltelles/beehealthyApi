package com.usjt.beehealthy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.model.Patient;
import com.usjt.beehealthy.model.User;
import com.usjt.beehealthy.repository.NutritionistRepository;
import com.usjt.beehealthy.repository.PatientRepository;
import com.usjt.beehealthy.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	NutritionistRepository nutritionistRepository;
	
	public Object login(User user) {
		User foundUser = userRepository.
				findByEmailAndPassword(
						user.getEmail(),user.getPassword());
		if (foundUser.getType().equals("patient")) {
			Patient patient = patientRepository.findByidUser(foundUser.getIdUser());
			patient.setUser(foundUser);
			return patient;
		} else if(foundUser.getType().equals("nutritionist")) {
			Nutritionist nutritionist = nutritionistRepository.findByidUser(foundUser.getIdUser());
			nutritionist.setUser(foundUser);
			return nutritionist;
		}else return user;
	}
	
	
	public Object register(Object user) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ObjectNode userJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(user));
			String type = userJson.with("user").get("type").asText();
			if(type.equals("patient")) {
				Patient patient = mapper.convertValue(userJson, Patient.class);
				patientRepository.save(patient);
			}else if(type.equals("nutritionist")) {
				Nutritionist nutritionist = mapper.convertValue(userJson, Nutritionist.class);
				return nutritionistRepository.save(nutritionist);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}

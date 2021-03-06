package com.usjt.beehealthy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	public Object login(User user) throws UserNotFound {
		try {
			User foundUser = userRepository.
					findByEmailAndPasswordAndType(
							user.getEmail(),user.getPassword(), user.getType());
			
			if (user.getType().equals("patient")) {
				Patient patient = patientRepository.findByiduser(foundUser.getIduser());
				patient.setIduser(foundUser.getIduser());
				patient.setEmail(foundUser.getEmail());
				patient.setPassword(foundUser.getPassword());
				return patient;
				
			} else if(user.getType().equals("nutritionist")) {
				Nutritionist nutritionist = nutritionistRepository.findByiduser(foundUser.getIduser());
				nutritionist.setIduser(foundUser.getIduser());
				nutritionist.setEmail(foundUser.getEmail());
				nutritionist.setPassword(foundUser.getPassword());
				return nutritionist;
			}
			return foundUser;
		}catch(NullPointerException e) {
			throw new UserNotFound("User not found.");
		}catch(Exception e) {
			return e;
		}
		
		
	}
	
	
	public Object register(Object user) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ObjectNode userJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(user));
			String type = userJson.get("type").asText();
			if(type.equals("nutritionist")) {
				Nutritionist nutritionist = mapper.convertValue(userJson, Nutritionist.class);
				return nutritionistRepository.save(nutritionist);
			}
			else if(type.equals("patient")) {
				Patient patient = mapper.convertValue(userJson, Patient.class);
				return patientRepository.save(patient);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User not found")
	public class UserNotFound extends Exception{
		private static final long serialVersionUID = 5594824708766567753L;
		public UserNotFound(String message) {
			super(message);
		}
	}
}

package com.usjt.beehealthy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.beehealthy.model.User;
import com.usjt.beehealthy.repository.NutritionistRepository;
import com.usjt.beehealthy.repository.PatientRepository;
import com.usjt.beehealthy.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private NutritionistRepository nutritionistRepository;

	public User register(User user) {

		userRepository.save(user);

		if (user.getType() == "patient") {
			patientRepository.save(user.getPatient());
		} else if (user.getType() == "nutritionist") {
			nutritionistRepository.save(user.getNutritionist());
		}

		return userRepository.save(user);
	}

	public User login(User user) {
		User foundUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (foundUser != null) {
			if (foundUser.getType().equals("patient")) {
				System.out.println(patientRepository.findByUser(foundUser.getIdUser()));
			} else if (foundUser.getType().equals("nutritionist")) {
				foundUser.setNutritionist(nutritionistRepository.findByUser(foundUser.getIdUser()));
			}
		}
		return foundUser;
	}
}

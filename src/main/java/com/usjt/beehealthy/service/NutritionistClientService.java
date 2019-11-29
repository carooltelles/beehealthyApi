package com.usjt.beehealthy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.model.NutritionistClient;
import com.usjt.beehealthy.model.Patient;
import com.usjt.beehealthy.repository.NutritionistClientRepository;

@Service
public class NutritionistClientService {

	@Autowired
	NutritionistClientRepository clientRepository;

	public NutritionistClient createClient(Nutritionist nutritionist, Patient patient) {
		try {
			NutritionistClient client = new NutritionistClient();
			client.setNutritionist(nutritionist);
			client.setPatient(patient);
			return clientRepository.save(client);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<NutritionistClient> findByNutritionist(Long idnutritionist) {
		try {
			return clientRepository.findPatientByNutritionistIduser(idnutritionist);
		} catch (Exception e) {
			throw e;
		}
	}

}

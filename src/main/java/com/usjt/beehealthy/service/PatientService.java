package com.usjt.beehealthy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usjt.beehealthy.model.Patient;
import com.usjt.beehealthy.repository.PatientRepository;

@Service
public class PatientService {


	@Autowired
	private PatientRepository patientRepository;

	public Patient registerPatient(Patient patient) {
		 return patientRepository.save(patient);
	}
	
//	public Patient login(Patient patient) {
//		return patientRepository.
//			findByUserEmailAndPassword(
//			patient.getUser().getEmail(), 
//			patient.getUser().getPassword());
//	}
}

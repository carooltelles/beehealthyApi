package com.usjt.beehealthy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usjt.beehealthy.model.Patient;
import com.usjt.beehealthy.repository.PatientRepository;

@Service
public class PatientService {


	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> findAllPatients(){
		try {
			return patientRepository.findAll();			
		}catch(Exception e) {
			throw e;
		}
	}

	public Patient findPatient(Long userId) {
		try {
			return patientRepository.findByiduser(userId);			
		}catch(Exception e) {
			throw e;
		}
	}
	
	public Patient updatePatient(Long userId, Patient patient) {
		try {
			Patient updatedPatient =  patientRepository.findByiduser(userId);
			updatedPatient.setDescription(patient.getDescription());
			updatedPatient.setEmail(patient.getEmail());
			updatedPatient.setFullname(patient.getFullname());
			updatedPatient.setPassword(patient.getPassword());
			updatedPatient.setHeight(patient.getHeight());
			updatedPatient.setWeight(patient.getWeight());
			updatedPatient.setBirthday(patient.getBirthday());
			return updatedPatient;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void deletePatient(Long userId) {
		try {
			patientRepository.deleteById(userId);			
		}catch(Exception e) {
			throw e;
		}
	}
}

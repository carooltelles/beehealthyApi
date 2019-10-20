package com.usjt.beehealthy.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.Patient;
import com.usjt.beehealthy.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@GetMapping("/")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody List<Patient> findAllPatients(){
		try {
			return patientService.findAllPatients();
		}catch(Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/{userId}")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody Patient findPatient(@PathVariable("userId") Long userId) {
		try {
			return patientService.findPatient(userId);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/{userId}")
	@Transactional
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody Patient updatePatient(@PathVariable("userId") Long userId, @RequestBody Patient patient) {
		try {
			return patientService.updatePatient(userId, patient);
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	
	@DeleteMapping("/{userId}")
	@Transactional
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody void deletePatient(@PathVariable("userId") Long userId) {
		try {
			patientService.deletePatient(userId);
		}catch(Exception e) {
			throw e;
		}
	}
}

package com.usjt.beehealthy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	public Patient findByiduser(Long id);
}

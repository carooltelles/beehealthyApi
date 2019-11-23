package com.usjt.beehealthy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.Consult;

public interface ConsultRepository extends JpaRepository<Consult, Long> {
	public Consult findByidconsult(Long id);
	
	public List<Consult> findByNutritionistIduserAndNutritionistType(Long id, String type);

	public List<Consult> findByPatientIduserAndPatientType(Long iduser, String type);
	
	public Consult deleteByidconsult(Long id);

}

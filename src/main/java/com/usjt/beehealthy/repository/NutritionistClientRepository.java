package com.usjt.beehealthy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.NutritionistClient;

public interface NutritionistClientRepository  extends JpaRepository<NutritionistClient, Long>{

	public List<NutritionistClient> findPatientByNutritionistIduser(Long idnutritionist);
	public List<NutritionistClient> findByNutritionistIduserAndPatientIduser(Long idnutritionist, Long idpatient);
	public void deleteByPatientIduser(Long iduser);

}

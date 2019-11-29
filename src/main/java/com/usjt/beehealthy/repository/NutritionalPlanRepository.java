package com.usjt.beehealthy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.NutritionalPlan;

public interface NutritionalPlanRepository extends JpaRepository<NutritionalPlan,Long>{

	public List<NutritionalPlan> findByPatientIduserAndNutritionistIduser(Long idpatient, Long idnutritionist);

	public NutritionalPlan findByidplan(Long idplan);

	public List<NutritionalPlan> findByPatientIduser(Long idpatient);

}

package com.usjt.beehealthy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.usjt.beehealthy.model.NutritionalPlan;
import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.model.Patient;
import com.usjt.beehealthy.repository.NutritionalPlanRepository;
import com.usjt.beehealthy.repository.NutritionistRepository;
import com.usjt.beehealthy.repository.PatientRepository;

@Service
public class NutritionalPlanService {

	@Autowired
	NutritionalPlanRepository planRepository;
	
	@Autowired
	NutritionistRepository nutricionistRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	
	public List<NutritionalPlan>findPlanByPatientAndNutritionist(Long idpatient, Long idnutritionist){
		try {
			return planRepository.findByPatientIduserAndNutritionistIduser(idpatient, idnutritionist);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public NutritionalPlan createPlan(Object planObject) throws Exception{
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode planJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(planObject));
			
			Long idnutritionist = planJson.get("nutritionist").asLong();
			Long idpatient = planJson.get("patient").asLong();
			String breakfast = planJson.get("breakfast").asText();
			String lunch = planJson.get("lunch").asText();
			String dinner = planJson.get("dinner").asText();
			String weekDay = planJson.get("weekDay").asText();
			
			Patient patient = patientRepository.findByiduser(idpatient);
			Nutritionist nutritionist = nutricionistRepository.findByiduser(idnutritionist);
			
			NutritionalPlan plan = new NutritionalPlan();
			
			plan.setWeekDay(weekDay);
			plan.setNutritionist(nutritionist);
			plan.setPatient(patient);
			plan.setBreakfast(breakfast);
			plan.setLunch(lunch);
			plan.setDinner(dinner);
			
			return planRepository.save(plan);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void deletePlan(Long idplan) {
		try {
			planRepository.deleteById(idplan);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public NutritionalPlan updatePlan(Long idplan, NutritionalPlan plan) {
		NutritionalPlan updatedPlan = planRepository.findByidplan(idplan);
		updatedPlan.setBreakfast(plan.getBreakfast());
		updatedPlan.setLunch(plan.getLunch());
		updatedPlan.setDinner(plan.getDinner());	
		updatedPlan.setWeekDay(plan.getWeekDay());
		return updatedPlan;
		
	}

	public List<NutritionalPlan> findPlanByPatient(Long idpatient) {
		try {
			return planRepository.findByPatientIduser(idpatient);
		}catch(Exception e) {
			throw e;
		}
		
	}
}

package com.usjt.beehealthy.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.NutritionalPlan;
import com.usjt.beehealthy.service.NutritionalPlanService;

@RestController
@RequestMapping("plan")
public class NutritionalPlanController {

	@Autowired
	NutritionalPlanService planService;
	
	@GetMapping("/nutritionist/{idnutritionist}/patient/{idpatient}")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody List<NutritionalPlan> findPlanByPatientAndNutritionist
	(@PathVariable("idnutritionist") Long idnutritionist, @PathVariable("idpatient") Long idpatient){
		try {
			return planService.findPlanByPatientAndNutritionist(idpatient, idnutritionist);
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	@GetMapping("/patient/{idpatient}")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody List<NutritionalPlan> findPlanByPatient
	(@PathVariable("idpatient") Long idpatient){
		try {
			return planService.findPlanByPatient(idpatient);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody NutritionalPlan createPlan (@RequestBody Object planObject) throws Exception {
		try {
			return planService.createPlan(planObject);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional
	@PutMapping("/{idplan}")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody NutritionalPlan updatePlan
	(@PathVariable("idplan") Long idplan, @RequestBody NutritionalPlan plan)  throws Exception{
		try {
			return planService.updatePlan(idplan, plan);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional 
	@DeleteMapping("/{idplan}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deletePlan(@PathVariable("idplan") Long idplan){
		try {
			planService.deletePlan(idplan);
		}catch(Exception e) {
			throw e;
		}
	}
}

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.service.NutritionistService;

@RestController
@RequestMapping("nutritionist")
public class NutritionistController {

	@Autowired
	NutritionistService nutritionistService;
	
	@GetMapping("/")
	public @ResponseBody List<Nutritionist> findAllNutritionist(){
		try {
			return nutritionistService.findAllNutritionist();
		}catch(Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/search")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody List<Nutritionist> findNutritionistByName(@RequestParam("fullname") String fullname){
		try {
			return nutritionistService.findNutritionistByName(fullname);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/{userId}")
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody Nutritionist findNutritionist(@PathVariable("userId") Long userId) {
		try {
			return nutritionistService.findNutritionist(userId);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/{userId}")
	@Transactional
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody Nutritionist updateNutritionist(@PathVariable("userId") Long userId, @RequestBody Nutritionist nutritionist) throws Exception {
		try {
			return nutritionistService.updateNutritionist(userId, nutritionist);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping("/{userId}")
	@Transactional
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody void deletePatient(@PathVariable("userId") Long userId) {
		try {
			nutritionistService.deleteNutritionist(userId);
		}catch(Exception e) {
			throw e;
		}
	}
}

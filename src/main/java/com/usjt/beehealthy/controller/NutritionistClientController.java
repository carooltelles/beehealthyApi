package com.usjt.beehealthy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.NutritionistClient;
import com.usjt.beehealthy.service.NutritionistClientService;

@RestController
@RequestMapping("/client")
public class NutritionistClientController {
	
	@Autowired
	NutritionistClientService clientService;

	@GetMapping("/nutritionist/{idnutritionist}")
	public @ResponseBody List<NutritionistClient> findByNutritionist(@PathVariable("idnutritionist") Long idnutritionist){
		try {
			return clientService.findByNutritionist(idnutritionist);
		}catch(Exception e) {
			throw e;
		}
	}
}

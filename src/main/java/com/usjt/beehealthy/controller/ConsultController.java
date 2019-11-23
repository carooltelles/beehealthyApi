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

import com.usjt.beehealthy.model.Consult;
import com.usjt.beehealthy.service.ConsultService;

@RestController
@RequestMapping("consult")
public class ConsultController {

	@Autowired
	ConsultService consultService;

	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Object register(@RequestBody Object consult) throws Exception {
		try {
			return consultService.register(consult);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/")
	public @ResponseBody List<Consult> findAllConsult() {
		try {
			return consultService.findAllConsult();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/patient/{iduser}")
	public @ResponseBody List<Consult> findConsultByPatient(@PathVariable ("iduser") Long iduser) {
		try {
			return consultService.findConsultByIdPatientAndType(iduser, "patient");
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/nutritionist/{iduser}")
	public @ResponseBody List<Consult> findConsultByNutritionist(@PathVariable ("iduser") Long iduser) {
		try {
			return consultService.findConsultByIdNutritionistAndType(iduser, "nutritionist");
		} catch (Exception e) {
			throw e;
		}
	}


	@GetMapping("/{idconsult}")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Consult findConsult(@PathVariable("idconsult") Long idconsult) {
		try {
			return consultService.findConsult(idconsult);
		} catch (Exception e) {
			throw e;
		}
	}

	@PutMapping("/{idconsult}")
	@Transactional
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Consult updateConsult(@PathVariable("idconsult") Long idconsult,
			@RequestBody Object consult) throws Exception{
		try {
			return consultService.updateConsult(idconsult, consult);
		} catch (Exception e) {
			throw e;
		}
	}

	@DeleteMapping("/{idconsult}")
	@Transactional
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody void deleteConsult(@PathVariable("idconsult") Long idconsult) {
		try {
			consultService.deleteConsult(idconsult);
		} catch (Exception e) {
			throw e;
		}
	}
}

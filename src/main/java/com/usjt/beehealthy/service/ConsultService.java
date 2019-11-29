package com.usjt.beehealthy.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.usjt.beehealthy.model.Consult;
import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.model.NutritionistClient;
import com.usjt.beehealthy.model.Patient;
import com.usjt.beehealthy.repository.ConsultRepository;
import com.usjt.beehealthy.repository.NutritionistRepository;
import com.usjt.beehealthy.repository.PatientRepository;

@Service
public class ConsultService {

	@Autowired
	ConsultRepository consultRepository;
	
	@Autowired
	NutritionistRepository nutricionistRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	NutritionistClientService clientService;
	
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public List<Consult> findAllConsult() {
		try {
			return consultRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	public Consult findConsult(Long idconsult) {
		try {
			return consultRepository.findByidconsult(idconsult);
		} catch (Exception e) {
			throw e;
		}
	}

	public Consult updateConsult(Long idconsult, Object consult) throws Exception{
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			ObjectNode consultJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(consult));
			
			Consult updatedConsult = consultRepository.findByidconsult(idconsult);
			
			Long idnutritionist = consultJson.get("idnutritionist").asLong();
			Nutritionist nutritionist = nutricionistRepository.findByiduser(idnutritionist);
			
			Long idpatient = Long.parseLong(consultJson.get("idpatient").asText());
			Patient patient = patientRepository.findByiduser(idpatient);
			
			updatedConsult.setDate(formatter.parse(consultJson.get("date").asText()));
			updatedConsult.setPlace(consultJson.get("place").asText());
			updatedConsult.setNutritionist(nutritionist);
			updatedConsult.setPatient(patient);
			return updatedConsult;

		} catch (Exception e) {
			throw e;
		}
	}

	public void deleteConsult(Long idconsult) {
		try {
			consultRepository.deleteById(idconsult);
		} catch (Exception e) {
			throw e;
		}
	}

	public Object register(Object consult) throws ParseException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ObjectNode userJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(consult));
			
			Consult consulta = new Consult();
			consulta.setDate(formatter.parse(userJson.get("date").asText()));
			consulta.setPlace(userJson.get("place").asText());
			
			Long idnutritionist = userJson.get("idnutritionist").asLong();
			Nutritionist nutritionist = nutricionistRepository.findByiduser(idnutritionist);
			consulta.setNutritionist(nutritionist);
			
			Long idpatient = Long.parseLong(userJson.get("idpatient").asText());
			Patient patient = patientRepository.findByiduser(idpatient);
			consulta.setPatient(patient);
			
			List<NutritionistClient> clients = clientService.findByNutritionistAndPatient(idnutritionist, idpatient);
			if(clients.size() == 0) clientService.createClient(nutritionist, patient);
			
			return consultRepository.save(consulta);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Consult> findConsultByIdNutritionistAndType(Long iduser, String type) {
		List<Consult> consults = consultRepository.findByNutritionistIduserAndNutritionistType(iduser, type);
		return consults;
	}
	
	public List<Consult> findConsultByIdPatientAndType(Long iduser, String type) {
		List<Consult> consults = consultRepository.findByPatientIduserAndPatientType(iduser, type);
		return consults;
	}
}

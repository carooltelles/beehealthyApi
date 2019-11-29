package com.usjt.beehealthy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.usjt.beehealthy.model.Articles;
import com.usjt.beehealthy.model.Nutritionist;
import com.usjt.beehealthy.repository.ArticlesRepository;
import com.usjt.beehealthy.repository.NutritionistRepository;


@Service
public class ArticlesService {

	@Autowired
	ArticlesRepository articleRepository;
	
	@Autowired
	NutritionistRepository nutritionistRepository;
	
	public Articles createArticle(Object article) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			ObjectNode articleJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(article));
			String idnutritionist = articleJson.get("idnutritionist").asText();
			System.out.println("ID DO NUTRITIONIST"+idnutritionist);
			Nutritionist nutritionist = nutritionistRepository.findByiduser(Long.parseLong(idnutritionist));
			
			
			// return articleRepository.save(article);
			return null;
		}catch(Exception e) {
			return null;			
		}
	}

}

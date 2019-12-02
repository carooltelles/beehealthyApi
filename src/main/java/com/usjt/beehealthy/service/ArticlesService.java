package com.usjt.beehealthy.service;

import java.util.List;

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
	
	public Articles createArticle(Object articleObject) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			ObjectNode articleJson = (ObjectNode) mapper.readTree(mapper.writeValueAsString(articleObject));
			Long idnutritionist = articleJson.get("nutritionist").asLong();
			String title = articleJson.get("title").asText();
			String text = articleJson.get("text").asText();
			Nutritionist nutritionist = nutritionistRepository.findByiduser(idnutritionist);
			Articles article = new Articles(title, text, nutritionist);
			
			return articleRepository.save(article);
		}catch(Exception e) {
			throw e;			
		}
	}

	public List<Articles> allArticles() {
		try {
			return articleRepository.findAll();			
		}catch(Exception e) {
			throw e;
		}
	}

}

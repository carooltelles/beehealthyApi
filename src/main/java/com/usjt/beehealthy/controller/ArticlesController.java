package com.usjt.beehealthy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.usjt.beehealthy.model.Articles;
import com.usjt.beehealthy.service.ArticlesService;

@RestController
@RequestMapping("articles")
public class ArticlesController {

	@Autowired
	ArticlesService articleService;
	
	
	@PostMapping("/")
	public @ResponseBody Articles createArticle(Object article) {
		try {
			return articleService.createArticle(article);
		}catch(Exception e) {
			throw e;
		}
	}
	
}

package com.usjt.beehealthy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public @ResponseBody Articles createArticle(@RequestBody Object article) throws Exception {
		try {
			return articleService.createArticle(article);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/")
	public @ResponseBody List<Articles> allArticles(){
		try {
			return articleService.allArticles();
		}catch(Exception e) {
			throw e;
		}
	}
	
}

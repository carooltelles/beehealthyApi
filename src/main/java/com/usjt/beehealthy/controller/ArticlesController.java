package com.usjt.beehealthy.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usjt.beehealthy.model.Articles;
import com.usjt.beehealthy.service.ArticlesService;

@RestController
@RequestMapping("articles")
public class ArticlesController {

	@Autowired
	ArticlesService articleService;
	
	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody Articles createArticle(@RequestBody Object article) throws Exception {
		try {
			return articleService.createArticle(article);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody List<Articles> allArticles(){
		try {
			return articleService.allArticles();
		}catch(Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping("/{idarticle}")
	@Transactional
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody void deleteArticle(@PathVariable("idarticle") Long idarticle) {
		try {
			articleService.deleteArticle(idarticle);
		}catch(Exception e) {
			throw e;
		}
	}
	
	
}

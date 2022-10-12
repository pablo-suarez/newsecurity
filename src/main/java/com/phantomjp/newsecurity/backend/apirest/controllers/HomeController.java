package com.phantomjp.newsecurity.backend.apirest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@GetMapping
	public String home() {
		return "Hello World";
	}
	
	@GetMapping("/only")
	public String onlyauth() {
		return "Only auth";
	}
	
	@GetMapping("/all")
	public String everybody() {
		return "Everybody";
	}
}

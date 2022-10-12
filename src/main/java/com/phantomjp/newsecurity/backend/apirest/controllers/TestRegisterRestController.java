package com.phantomjp.newsecurity.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phantomjp.newsecurity.backend.apirest.models.dto.TestRegisterDto;
import com.phantomjp.newsecurity.backend.apirest.models.services.ITestRegisterService;

@RestController
@RequestMapping("/testregister")
public class TestRegisterRestController {

	@Autowired
	private ITestRegisterService testRegisterService;
	
	@GetMapping("/all")
	public List<TestRegisterDto> index(){
		return testRegisterService.findAll();
	}
	
}

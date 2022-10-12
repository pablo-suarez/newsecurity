package com.phantomjp.newsecurity.backend.apirest.models.services;

import java.util.List;

import com.phantomjp.newsecurity.backend.apirest.models.dto.TestRegisterDto;

public interface ITestRegisterService {
	public List<TestRegisterDto> findAll();
}

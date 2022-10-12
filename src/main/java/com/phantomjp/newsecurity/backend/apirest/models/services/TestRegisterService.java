package com.phantomjp.newsecurity.backend.apirest.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phantomjp.newsecurity.backend.apirest.models.dao.ITestRegisterDao;
import com.phantomjp.newsecurity.backend.apirest.models.dto.TestRegisterDto;
import com.phantomjp.newsecurity.backend.apirest.models.entity.TestRegisterEntity;

@Service
public class TestRegisterService implements ITestRegisterService{

	@Autowired
	private ITestRegisterDao testRegisterDao;

	@Override
	@Transactional(readOnly = true)
	public List<TestRegisterDto> findAll() {
		// TODO Auto-generated method stub
		List<TestRegisterEntity> testRegisterList = (List<TestRegisterEntity>) testRegisterDao.findAll();
		return testRegisterList.stream().map(it->fromEntityToDto(it)).collect(Collectors.toList());
	}
	
	public static TestRegisterDto fromEntityToDto(TestRegisterEntity entity) {
		return new TestRegisterDto(entity.getId(),entity.getName(),entity.getDescription());
	}

}

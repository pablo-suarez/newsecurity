package com.phantomjp.newsecurity.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.phantomjp.newsecurity.backend.apirest.models.entity.TestRegisterEntity;

public interface ITestRegisterDao extends CrudRepository<TestRegisterEntity,Integer>{

}

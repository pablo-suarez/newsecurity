package com.phantomjp.newsecurity.backend.apirest.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.phantomjp.newsecurity.backend.apirest.models.entity.UserEntity;

public interface IUserDao extends CrudRepository<UserEntity,Integer>{
	UserEntity findByEmail(String email);
}

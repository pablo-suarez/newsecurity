package com.phantomjp.newsecurity.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.phantomjp.newsecurity.backend.apirest.models.dao.IUserDao;
import com.phantomjp.newsecurity.backend.apirest.models.entity.SecurityUser;
import com.phantomjp.newsecurity.backend.apirest.models.entity.UserEntity;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	private final IUserDao userDao;
	
	public JpaUserDetailsService(IUserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Entra");
		
		UserEntity user = userDao.findByEmail(email);
		
		if(user == null) {
			logger.error("No existe el usuario "+email+" en el sistema");
			throw new UsernameNotFoundException("No existe el usuario "+email+" en el sistema");
		}
		System.out.println("Usuario es "+user.getPassword());
		return new SecurityUser(user);
		/*
		return userDao.findByEmail(email)
		
		.map(SecurityUser::new)

		.orElseThrow(() -> new UsernameNotFoundException("Email not found"+email));*/
		
		
	}

}

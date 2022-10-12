package com.phantomjp.newsecurity.backend.apirest.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.phantomjp.newsecurity.backend.apirest.models.services.JpaUserDetailsService;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	private JpaUserDetailsService jpaUserDetailsService;
	
	
	
	public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
		this.jpaUserDetailsService = jpaUserDetailsService;
	}



	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("Validando");
		return http
        .csrf().disable()
        .authorizeRequests(auth -> auth
                .antMatchers("/all").permitAll()
                .antMatchers("/only").hasAuthority("admin")
                .anyRequest().authenticated()
        )
        .userDetailsService(jpaUserDetailsService)
        .headers(headers -> headers.frameOptions().sameOrigin())
        .httpBasic(withDefaults())
        .build();
		/*
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		*/
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}

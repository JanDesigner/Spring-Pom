package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class JavaWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
				
				http.authorizeRequests()
					.antMatchers("/").hasRole("EMPLOYEE")
					.antMatchers("/leaders").hasRole("MANAGER")
					.antMatchers("/admins").hasRole("ADMIN")
				.and()
					.formLogin()
					.loginPage("/myLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
					.logout().permitAll()
				.and()
					.exceptionHandling().accessDeniedPage("/nope");
				
	}
	
	
	
	
	
}

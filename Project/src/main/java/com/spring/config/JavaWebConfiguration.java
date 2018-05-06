package com.spring.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.spring")
@PropertySource("classpath:jdbc.properties")
public class JavaWebConfiguration {
	
	@Autowired
	private Environment env;
	
	
	@Bean 
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource securityDataSource = 
				new ComboPooledDataSource();
		
		try { 
			
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.username"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));
			
			System.out.println(env.getProperty("jdbc.driver"));
			System.out.println(env.getProperty("jdbc.url"));
			System.out.println(getIntProp("connection.pool.initialPoolSize"));
			System.out.println(getIntProp("connection.pool.minPoolSize"));
			System.out.println(	getIntProp("connection.pool.maxIdleTime"));
			
			
			
			//c3p0
			
			securityDataSource.setInitialPoolSize(
					getIntProp("connection.pool.initialPoolSize"));
			securityDataSource.setMinPoolSize(
					getIntProp("connection.pool.minPoolSize"));
			securityDataSource.setMaxPoolSize(
					getIntProp("connection.pool.maxPoolSize"));
			securityDataSource.setMaxIdleTime(
					getIntProp("connection.pool.maxIdleTime"));
			
		} catch ( PropertyVetoException exc  ) {
			throw new RuntimeException(exc);
		}
		
			
		return securityDataSource;
	}
	
	
	public int getIntProp(String propName) {
		
		String propVal = env.getProperty(propName);
		int intProp = Integer.parseInt(propVal);
		
		return intProp;
	}

}

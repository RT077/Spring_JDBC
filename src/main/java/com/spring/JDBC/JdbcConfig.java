package com.spring.JDBC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.JDBC.dao.StudentDao;
import com.spring.JDBC.dao.StudentDaoImlpl;

@Configuration
@ComponentScan(basePackages = { "com.spring.JDBC.dao" })
public class JdbcConfig {
	// creating database
	
	@Bean("driversource")
	public DriverManagerDataSource getDriver() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}

	// jdbcTemplate object creation

	@Bean("jdbctemplate")
	public JdbcTemplate getTempalte() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDriver());

		return jdbcTemplate;
	}

	@Bean("stdsaoimpl")
	public StudentDao getStudentDao() {

		StudentDaoImlpl daoImlpl = new StudentDaoImlpl();
		daoImlpl.setJdbcTemplate(getTempalte());

		return daoImlpl;

	}
}

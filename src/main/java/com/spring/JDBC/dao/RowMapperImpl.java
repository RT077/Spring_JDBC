package com.spring.JDBC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.JDBC.entites.Student;

public class RowMapperImpl implements RowMapper<Student> {

	//@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		
		student.setStd_id(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setSurname(rs.getString(3));
		student.setCity(rs.getString(4));
		
		return student;
	}

}

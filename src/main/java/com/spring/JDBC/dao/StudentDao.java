package com.spring.JDBC.dao;

import java.util.List;

import com.spring.JDBC.entites.Student;

public interface StudentDao {
	public int insert(Student student);
	public int update(Student student);
	public int delete(Student studentid);
	public List<Student> getAllStudent();
	
	
}

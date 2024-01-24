package com.spring.JDBC.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.JDBC.entites.Student;

@Component("stdsaoimpl")
public class StudentDaoImlpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//@Override
	public int insert(Student student) {
		// insert query
		String query = "insert into student(std_id,name,surname,city) values(?,?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getStd_id(), student.getName(), student.getSurname(),
				student.getCity());
		return result;
	}

	//@Override
	public int update(Student student) {
		// Updatig data
		String query = "update student set name=?, surname=?, city=? where std_id=?";
		int update = this.jdbcTemplate.update(query, student.getName(), student.getSurname(), student.getCity(),
				student.getStd_id());
		return update;
	}

	//@Override
	public int delete(Student studentid) {
		// seleting the data
		String query = "delete from student where std_id=?";
		int delete = this.jdbcTemplate.update(query, studentid.getStd_id());
		return delete;
	}

	//@Override
	public List<Student> getAllStudent() {
		// selecting multiple student

		String query = "select *from student";
		List<Student> query2 = this.jdbcTemplate.query(query, new RowMapperImpl());
		return query2;
	}

}

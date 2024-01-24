package com.spring.JDBC;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.JDBC.dao.StudentDao;
import com.spring.JDBC.dao.StudentDaoImlpl;
import com.spring.JDBC.entites.Student;

/**
 * Hello world!
 *
 */
public class App {

	private static Scanner sc = new Scanner(System.in);

	private static int menuList() {
		System.out.println("0 :- Exist");
		System.out.println("1 :- Insert");
		System.out.println("2 :- Update");
		System.out.println("3 :- Delete");
		System.out.println("4 :- Fetching All Data");
		System.out.print("Enter the Choice :- ");

		return sc.nextInt();
	}

	public static void setRecord(Student std) {

		System.out.print("Student Id	:- ");
		std.setStd_id(sc.nextInt());

		System.out.print("Student name	:- ");
		std.setName(sc.next());

		System.out.print("Student surname	:- ");
		std.setSurname(sc.next());

		System.out.print("Student city	:- ");
		std.setCity(sc.next());

	}

	private static void updateRecord(Student std) {
		std.setStd_id(sc.nextInt());
		std.setName(sc.next());
		std.setSurname(sc.next());
		std.setCity(sc.next());

	}

	private static void deleteRecord(Student std) {
		System.out.print("enter the Id = ");
		std.setStd_id(sc.nextInt());

	}

	private static void fetchingRecord(Student std) {

	}

	public static void main(String[] args) {

		System.out.println("program started");

		// spring jdbc -> jdbc template Using XML

		// ApplicationContext conn = new
		// ClassPathXmlApplicationContext("com/spring/JDBC/jdbcconfig.xml");
		// without using xml file used Annotaion based java class

		ApplicationContext conn = new AnnotationConfigApplicationContext(JdbcConfig.class);

		// JdbcTemplate template = conn.getBean("jdbctemplate", JdbcTemplate.class);

		StudentDao studentDao = conn.getBean("stdsaoimpl", StudentDao.class);

		/*
		 * inserting data
		 * 
		 * Student student = new Student(); student.setStd_id(sc.nextInt());
		 * student.setName(sc.next()); student.setCity(sc.next());
		 * 
		 * Changing data
		 * 
		 * Student student1 = new Student(); student.setStd_id(14);
		 * student.setName("yash modale"); student.setCity("indapur");
		 * 
		 * int update1 = studentDao.update(student1); System.out.println("data Changed"
		 * + update1);
		 * 
		 * deleting data Student student2 = new Student();
		 * System.out.println("enter the Id = "); student.setStd_id(sc.nextInt());
		 * 
		 * int delet1 = studentDao.delete(student2); System.out.println("data Delete" +
		 * delet1);
		 * 
		 */

		int choice;
		int student;

		while ((choice = App.menuList()) != 0) {
			Student std = null;
			switch (choice) {

			// inserting data

			case 1:
				std = new Student();
				App.setRecord(std);
				if (std != null) {
					int res = studentDao.insert(std);
					System.out.println("student ADDED " + res);
					System.out.println("*** done case 1 ****");
				}

				break;

			// Changing data
			case 2:
				std = new Student();
				if (std != null) {
					App.updateRecord(std);

					int update1 = studentDao.update(std);
					System.out.println("data UPDATE" + update1);
					System.out.println("*** done case 2 ****");
				}
				break;

			// deleting data
			case 3:
				std = new Student();
				App.deleteRecord(std);
				if (std != null) {
					int delete = studentDao.delete(std);
					System.out.println("data DELETE" + delete);
					System.out.println("*** done case 3 ****");
					break;
				}
			case 4:
				std = new Student();
				App.fetchingRecord(std);
				if (std != null) {
					List<Student> fetch = studentDao.getAllStudent();

					for (Student stdfet : fetch) {
						System.out.println(stdfet);
					}

					System.out.println("*** done case 4 ****");
					break;
				}
			}
		}
		System.out.println("### PROGRAM EXIT ###");

	}

}

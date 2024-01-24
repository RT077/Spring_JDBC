package com.spring.JDBC.entites;

public class Student {
	private int std_id;
	private String name;
	private String surname;
	private String city;

	public Student() {
		super();
	}

	public Student(int std_id, String name, String surname, String city) {
		this.std_id = std_id;
		this.name = name;
		this.surname = surname;
		this.city = city;
	}

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", name=" + name + ", surname=" + surname + ", city=" + city + "]";
	}

}

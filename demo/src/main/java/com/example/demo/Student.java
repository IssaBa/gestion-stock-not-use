package com.example.demo;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence")
	
	private long id ;
	private String name ;
	private String email ;
	
	@Transient
	private Integer age ;
	
	private LocalDate dod ;
	
	public Student(
			long id,
			String name,
			String email,
			LocalDate dod) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dod = dod;
	}
	
	
	public Student(
			String name,
			String email,
			LocalDate dod) {
		super();
		
		this.name = name;
		this.email = email;
		this.dod = dod;
	}


	
	public Student() {
	}
	
	@Override
	public String toString() {
		return "Student "
				+ "[ id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", dod=" + dod + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getAge() {
		return Period.between(this.dod, LocalDate.now()).getYears();
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public LocalDate getDod() {
		return dod;
	}


	public void setDod(LocalDate dod) {
		this.dod = dod;
	}
	
	
		

}

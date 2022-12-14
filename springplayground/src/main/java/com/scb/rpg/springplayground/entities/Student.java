package com.scb.rpg.springplayground.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity --> represents the java class
@Entity(name="Student")
//@Table --> represents backend
@Table(name="student")
public class Student {
//	Representing the Primary Key
	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
			)
	@Column(name="student_id")
	private int id;
	
	@Column(
			name = "first_name",
			nullable = false,
			columnDefinition = "TEXT"
			)
	private String firstName;
	
	@Column(
			name = "last_name",
			nullable = false,
			columnDefinition = "TEXT"
			)
	private String lastName;
	
	@Column(
			name = "email",
			nullable = false,
			columnDefinition = "TEXT"
			)
	private String email;
	
	@Column(
			name = "age",
			nullable = false,
			columnDefinition = "INTEGER"
			)
	private int age;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String firstName, String lastName, String email, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", age=" + age + "]";
	}
	
	
	

}

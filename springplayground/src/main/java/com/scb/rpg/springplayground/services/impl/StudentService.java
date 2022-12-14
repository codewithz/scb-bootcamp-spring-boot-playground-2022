package com.scb.rpg.springplayground.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.rpg.springplayground.dao.impl.StudentRepository;
import com.scb.rpg.springplayground.entities.Student;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public String addStudent(Student student) {
		
		Student studentAdded=studentRepository.save(student);
		
		if(studentAdded!=null) {
			return "SUCCESS";
		}
		else {
			//Exception Handling
			return "FAILURE";
		}
		
	}
	
	public String updateStudent(Student student,int id) {
		student.setId(id);
		Student studentUpdated=studentRepository.save(student);
		
		if(studentUpdated!=null) {
			return "SUCCESS";
		}
		else {
			//Exception Handling
			return "FAILURE";
		}
		
	}
	
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "SUCCESS";
	}
	
	public List<Student> getAllStudents(){
		
		List<Student> students=studentRepository.findAll();
		return students;
	}
	
	
	public Student getStudentById(int id) {
		Student student=null;
	Optional<Student> optional=studentRepository.findById(id);
	if(optional.isPresent()) {
		student=optional.get();
	}
	else {
		student =null;
	}
	return student;
		
	}
	
}

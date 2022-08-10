package com.scb.rpg.springplayground.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scb.rpg.springplayground.config.payloads.ApiSuccessPayload;
import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.entities.Student;
import com.scb.rpg.springplayground.services.ICustomerService;
import com.scb.rpg.springplayground.services.impl.StudentService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<ApiSuccessPayload> getAllStudents(){
		
		List<Student> students=studentService.getAllStudents();
		HttpStatus status=HttpStatus.OK;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(students, "Students List Found", status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<ApiSuccessPayload> getStudentById(@PathVariable int id) {
		Student s=studentService.getStudentById(id);
		HttpStatus status=HttpStatus.OK;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(s,"Student Found", status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@PostMapping("/students")
	public ResponseEntity<ApiSuccessPayload> addStudent(@RequestBody Student s) {
		String message=studentService.addStudent(s);
		HttpStatus status=HttpStatus.CREATED;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(message, message, status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<ApiSuccessPayload> updateStudent(@RequestBody Student s,@PathVariable int id) {
		String message=studentService.updateStudent(s, id);
		HttpStatus status=HttpStatus.CREATED;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(message, message, status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<ApiSuccessPayload> deleteStudent(@PathVariable int id) {
		String message=studentService.deleteStudent(id);
		HttpStatus status=HttpStatus.OK;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(message, message, status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}

}

package com.example.Springboot.Restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboot.Restapi.Entity.Student;
import com.example.Springboot.Restapi.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	//get all students
	@GetMapping("/students")
	public List<Student>getAllStudents(){
		List<Student> students = repo.findAll();
		
		return students;
	}
	
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id ) {
		Student student =repo.findById(id).get();
		return student;
	}

}

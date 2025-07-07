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
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student){
		{
			repo.save(student);
	}
		
		
	}
	@PutMapping("/student/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setPercentage(92);
		student.setName("poonam");
		repo.save(student);
		return student;
		
	}
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}

}




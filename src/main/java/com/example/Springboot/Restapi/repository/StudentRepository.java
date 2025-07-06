package com.example.Springboot.Restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springboot.Restapi.Entity.Student;

public interface StudentRepository extends JpaRepository<Student ,Integer>{

}

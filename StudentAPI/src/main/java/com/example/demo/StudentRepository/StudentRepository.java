package com.example.demo.StudentRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.springframework.data.domain.Page;


import com.example.demo.Studentmodel.student;
public interface StudentRepository extends JpaRepository <student,Integer>{
	
	Page<student> findAll(Pageable pageable);

	//List<student> findByName(String name);

	

	List<student> findByNameContainsIgnoreCase(String name);

}

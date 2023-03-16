package com.example.demo.StudentRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;


import com.example.demo.Studentmodel.student;
public interface StudentRepository extends JpaRepository <student,Integer>{
	
	Page<student> findAll(Pageable pageable);

	

}

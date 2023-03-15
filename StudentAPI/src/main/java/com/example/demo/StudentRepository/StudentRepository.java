package com.example.demo.StudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Studentmodel.student;
public interface StudentRepository extends JpaRepository <student,Integer>{

}

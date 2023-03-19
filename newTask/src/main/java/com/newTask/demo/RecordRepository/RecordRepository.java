package com.newTask.demo.RecordRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newTask.demo.Model.MyRecord;

@Repository
public interface RecordRepository extends JpaRepository<MyRecord, Long> {
    Optional<MyRecord> findByEmailAddress(String emailAddress);

	
	
}


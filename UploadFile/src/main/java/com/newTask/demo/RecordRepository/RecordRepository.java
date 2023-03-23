package com.newTask.demo.RecordRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newTask.demo.Model.MyRecord;

@Repository
public interface RecordRepository extends JpaRepository<MyRecord, Long> {

//	 save(MyRecord record);

	//MyRecord findByEmail(String email);
	MyRecord findByEmail(String email);

	void delete(MyRecord existingRecord);
	
	MyRecord findByPhoneNumber(String phoneNumber);
}


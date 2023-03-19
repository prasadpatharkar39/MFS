package com.newTask.demo.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.newTask.demo.Model.MyRecord;
import com.newTask.demo.RecordRepository.RecordRepository;
@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public void processRecords(MultipartFile file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            String firstName = parts[0];
            String lastName = parts[1];
            String emailAddress = parts[2].substring(0, parts[2].length() - 1);
            char action = parts[2].charAt(parts[2].length() - 1);
            switch (action) {
                case 'A':
                    addRecord(new MyRecord(firstName, lastName, emailAddress));
                    break;
                case 'U':
                    updateRecord(emailAddress, new MyRecord(firstName, lastName, emailAddress));
                    break;
                case 'D':
                    deleteRecord(emailAddress);
                    break;
            }
        }
    }

    private String addRecord(MyRecord record) {
        // Set the emailAddress field to a default value if it's null
        if (record.getEmailAddress() == null) {
            record.setEmailAddress("default@example.com");
        }
        recordRepository.save(record);
        return "Record Inserted";
    }


    private String updateRecord(String emailAddress, MyRecord record) {
        Optional<MyRecord> existingRecord = recordRepository.findByEmailAddress(emailAddress);
        if (existingRecord.isPresent()) {
            existingRecord.get().setFirstName(record.getFirstName());
            existingRecord.get().setLastName(record.getLastName());
            recordRepository.save(existingRecord.get());
            
        }
        return "Record Updated";
    }

    private String deleteRecord(String emailAddress) {
    	Optional<MyRecord> record = recordRepository.findByEmailAddress(emailAddress);
    	if (record.isPresent()) {
    	    recordRepository.delete(record.get());
    	}
    	return "Record Updated";
    }


}

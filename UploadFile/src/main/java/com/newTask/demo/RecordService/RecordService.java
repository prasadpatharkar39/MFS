package com.newTask.demo.RecordService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.newTask.demo.Model.MyRecord;
import com.newTask.demo.RecordRepository.RecordRepository;


@Service
public class RecordService {
	
	

    public class ProcessFileResult {
    	
    	private final int addedCount;
        private final int updatedCount;
        private final int deletedCount;

        public ProcessFileResult(int addedCount, int updatedCount, int deletedCount) {
            this.addedCount = addedCount;
            this.updatedCount = updatedCount;
            this.deletedCount = deletedCount;
        }

        public int getAddedCount() {
            return addedCount;
        }

        public int getUpdatedCount() {
            return updatedCount;
        }

        public int getDeletedCount() {
            return deletedCount;
        }

	}
	private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
    public ProcessFileResult processFile(MultipartFile file) throws IOException  {
    	   int addedCount = 0;
    	    int updatedCount = 0;
    	    int deletedCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
//    public void processFile(String filename) throws IOException  {
//        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String Id = line.substring(0, 4);
           // String BucketId = line.substring(4, 8);
            String firstName = line.substring(8, 17);
            String lastName = line.substring(17, 25);
            String mobileNumber = line.substring(25, 35);
            String email = line.substring(35, line.length() - 1);
            char lastLetter = line.charAt(line.length() - 1);
            
           
			if (lastLetter == 'A') {
            	
            	 MyRecord existingRecord = recordRepository.findByEmail(email);
            	    if (existingRecord == null) {
            	        MyRecord record = new MyRecord(firstName, lastName, mobileNumber, email);
            	        addedCount++;
            	        recordRepository.save(record);
            	    } else {
            	        //  if Record already exists, do nothing
            	    }
            	}  else if (lastLetter == 'U') {
                MyRecord existingRecord = recordRepository.findByEmail(email);
        	    if (existingRecord == null) {
        	        MyRecord record = new MyRecord(firstName, lastName, mobileNumber, email);
        	        addedCount++;
        	        recordRepository.save(record);
        	    } else {existingRecord.setFirstName(firstName);
                existingRecord.setLastName(lastName);
                existingRecord.setPhoneNumber(mobileNumber);
                
                updatedCount++;
                recordRepository.save(existingRecord);}
        	    
                
            } else if (lastLetter == 'D') {
                MyRecord existingRecord = recordRepository.findByEmail(email);
                if(existingRecord != null) {
                	
                	deletedCount++;
                recordRepository.delete(existingRecord);
                }else {
                	
                	// DO NOTHING
                }
                
                
            }
        }
		return new ProcessFileResult(addedCount, updatedCount, deletedCount);
    }
	

}

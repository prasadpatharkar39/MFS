package com.newTask.demo.RestController;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newTask.demo.Model.MyRecord;
import com.newTask.demo.RecordRepository.RecordRepository;
import com.newTask.demo.RecordService.RecordService;

@RestController
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processFile(@RequestParam("file") MultipartFile file) {
        try {
            RecordService.ProcessFileResult result = recordService.processFile(file);
            String response = String.format("File processed successfully. Added: %d, Updated: %d, Deleted: %d",
                    result.getAddedCount(), result.getUpdatedCount(), result.getDeletedCount());
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file.");
        }
    }
    

}


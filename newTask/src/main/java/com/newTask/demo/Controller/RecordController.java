package com.newTask.demo.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newTask.demo.Service.RecordService;

@RestController
@RequestMapping("/api/records")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @PostMapping("/process")
    public ResponseEntity<Void> processRecords(@RequestParam("file") MultipartFile file) {
        try {
            recordService.processRecords(file);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}


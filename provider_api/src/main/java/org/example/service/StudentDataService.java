package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.Address;
import org.example.controller.dto.Student;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentDataService {
    public Student getStudent(String rollId) {
        log.info("Passed Rollid "+rollId);
        return new Student("ADR456", "Tom Hardy", 67, new Address("Amstelveen", "netherlands"));
    }
}

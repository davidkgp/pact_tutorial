package org.example.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.Address;
import org.example.controller.dto.Student;
import org.example.service.interfaces.IStudentDataService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentDataServiceImpl implements IStudentDataService {


    public Student getStudentDummy(String rollId) {
        log.info("Passed Rollid "+rollId);
        return new Student("ADR456", "Tom Hardy", 67, new Address("Amstelveen", "netherlands"));
    }

    @Override
    public Student getStudent(String rollId) {
        return null;
    }
}

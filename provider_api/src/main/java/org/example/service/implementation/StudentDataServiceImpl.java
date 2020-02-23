package org.example.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.Address;
import org.example.controller.dto.Student;
import org.example.repository.interfaces.IStudentRepository;
import org.example.repository.interfaces.dto.StudentData;
import org.example.service.interfaces.IStudentDataService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentDataServiceImpl implements IStudentDataService {

    private final IStudentRepository studentRepository;


    public Student getStudentDummy(String rollId) {
        log.info("Passed Rollid " + rollId);
        return new Student(UUID.randomUUID(), "Tom Hardy", 67, new Address("Amstelveen", "netherlands"));
    }

    @Override
    public Student getStudent(String rollId) {
        return studentRepository.findById(rollId).map(StudentData::map).orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
    }

    @Override
    public Student createStudent(Student studentInput) {
        log.info(studentInput.toString());
        return StudentData.map(studentRepository.save(Student.map(studentInput)));
    }
}

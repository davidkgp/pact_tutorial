package org.example.service.interfaces;

import org.example.controller.dto.Student;

public interface IStudentDataService {

    Student getStudentDummy(String rollId);

    Student getStudent(String rollId);

    Student createStudent(Student studentInput);
}

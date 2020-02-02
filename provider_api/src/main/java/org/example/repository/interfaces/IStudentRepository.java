package org.example.repository.interfaces;


import org.example.repository.interfaces.dto.StudentData;
import org.springframework.data.repository.CrudRepository;


public interface IStudentRepository extends CrudRepository<StudentData, String> {

}

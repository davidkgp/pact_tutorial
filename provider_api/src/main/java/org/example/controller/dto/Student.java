package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.repository.interfaces.dto.StudentData;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Student extends RepresentationModel<Student> {

    private UUID rollId;
    private String fullName;
    private int age;
    private Address address;

    public static StudentData map(Student studentInput) {
        String firstName = studentInput.getFullName().substring(0,studentInput.getFullName().indexOf(" "));
        String lastName = studentInput.getFullName().substring(studentInput.getFullName().indexOf(" ")+1, studentInput.getFullName().length());

        return new StudentData(firstName, lastName, studentInput.getAge(), Address.map(studentInput.getAddress()));

    }
}

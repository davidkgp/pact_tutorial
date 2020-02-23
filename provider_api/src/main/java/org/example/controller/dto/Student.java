package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.repository.interfaces.dto.StudentData;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Student extends RepresentationModel<Student> {

    private String rollId;
    private String fullName;
    private int age;
    private Address address;

    public static StudentData map(Student studentInput) {
        String firstName = studentInput.getFullName().substring(studentInput.getFullName().indexOf(" "));
        String lastName = studentInput.getFullName().substring(studentInput.getFullName().indexOf(" "), studentInput.getFullName().length() + 1);

        return new StudentData(firstName, lastName, studentInput.getAge(), Address.map(studentInput.getAddress()));

    }
}

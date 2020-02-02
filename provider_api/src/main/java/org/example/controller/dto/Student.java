package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Student extends RepresentationModel<Student> {

    private String rollId;
    private String fullName;
    private int age;
    private Address address;
}

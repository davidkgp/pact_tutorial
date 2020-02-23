package org.example.repository.interfaces.dto;

import lombok.*;
import org.example.controller.dto.Student;

import javax.persistence.*;

@Entity(name = "students")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public final class StudentData {


    public StudentData(String firstName, String lastName, int age, AddressData addressData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressData = addressData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private String rollId;

    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private AddressData addressData;

    public static Student map(StudentData studentData){

        return new Student
                (studentData.rollId,
                        studentData.firstName+" "+studentData.lastName,
                        studentData.age,
                        AddressData.map(studentData.addressData));
    }


}

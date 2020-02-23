package org.example.repository.interfaces.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.controller.dto.Student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.UUID;

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
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID rollId;

    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private AddressData addressData;

    public static Student map(StudentData studentData) {

        return new Student
                (studentData.rollId,
                        studentData.firstName + " " + studentData.lastName,
                        studentData.age,
                        AddressData.map(studentData.addressData));
    }


}

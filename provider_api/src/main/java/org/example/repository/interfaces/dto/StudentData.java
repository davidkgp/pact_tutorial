package org.example.repository.interfaces.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.controller.dto.Student;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "students")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@GenericGenerator(name="student_roll"
        ,strategy = "org.example.repository.interfaces.dto.RollIdGenerator"
        ,parameters = {
        @Parameter(name = RollIdGenerator.VALUE_PREFIX_PARAMETER, value = "AG"),
        @Parameter(name = RollIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
public final class StudentData {


    public StudentData(String firstName, String lastName, int age, AddressData addressData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressData = addressData;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "student_roll")
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

    public static Student map(StudentData studentData) {

        return new Student
                (studentData.rollId,
                        studentData.firstName + " " + studentData.lastName,
                        studentData.age,
                        AddressData.map(studentData.addressData));
    }


}

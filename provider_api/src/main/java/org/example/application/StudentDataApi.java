package org.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example")
public class StudentDataApi {
    public static void main(String[] args) {
        SpringApplication.run(StudentDataApi.class, args);

    }
}

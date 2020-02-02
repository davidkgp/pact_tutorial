package org.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.example")
@EnableJpaRepositories("org.example.repository.interfaces")
@EntityScan("org.example.repository.interfaces.dto")
public class StudentDataApi {
    public static void main(String[] args) {
        SpringApplication.run(StudentDataApi.class, args);

    }
}

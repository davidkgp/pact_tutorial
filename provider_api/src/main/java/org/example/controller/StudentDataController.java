package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.Student;
import org.example.service.StudentDataService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor//(onConstructor = @__(@Autowired))
public class StudentDataController {

    private final StudentDataService studentDataService;

    @GetMapping(value = "/keepalive")
    public HttpEntity<String> keepAlive() {
        return new ResponseEntity<>("Alive", HttpStatus.OK);
    }


    @GetMapping(path = "/student/{id}")
    public HttpEntity<Student> getStudent(@PathVariable("id") String rollId) {

        Student student = studentDataService.getStudent(rollId);
        student.add(linkTo(methodOn(StudentDataController.class).getStudent(rollId)).withSelfRel());
        return new ResponseEntity<>(student, HttpStatus.OK);


    }

}

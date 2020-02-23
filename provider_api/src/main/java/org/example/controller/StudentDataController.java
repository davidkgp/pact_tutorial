package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.Student;
import org.example.service.interfaces.IStudentDataService;
import org.springframework.hateoas.LinkRelation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor//(onConstructor = @__(@Autowired))
public class StudentDataController {

    private final IStudentDataService studentDataService;

    @GetMapping(value = "/keepalive")
    public HttpEntity<String> keepAlive() {
        return new ResponseEntity<>("Alive", HttpStatus.OK);
    }


    @GetMapping(path = "/studentdummy/{id}")
    public HttpEntity<Student> getStudentDummy(@PathVariable("id") String rollId) {

        Student student = studentDataService.getStudentDummy(rollId);
        student.add(linkTo(methodOn(StudentDataController.class).getStudentDummy(rollId)).withSelfRel());
        student.add(linkTo(methodOn(StudentDataController.class).deleteStudent(rollId)).withRel(LinkRelation.of(HttpMethod.DELETE.name())));
        return new ResponseEntity<>(student, HttpStatus.OK);


    }

    @GetMapping(path = "/student/{id}")
    public HttpEntity<Student> getStudent(@PathVariable("id") String rollId) {

        Student student = studentDataService.getStudent(rollId);
        student.add(linkTo(methodOn(StudentDataController.class).getStudent(rollId)).withSelfRel());
        student.add(linkTo(methodOn(StudentDataController.class).deleteStudent(rollId)).withRel(LinkRelation.of(HttpMethod.DELETE.name())));
        return new ResponseEntity<>(student, HttpStatus.OK);


    }

    @PostMapping(path = "/student")
    public HttpEntity<Student> createStudent(@RequestBody Student studentInput) {

        Student student = studentDataService.createStudent(studentInput);
        student.add(linkTo(methodOn(StudentDataController.class).getStudent(student.getRollId().toString())).withSelfRel());
        student.add(linkTo(methodOn(StudentDataController.class).deleteStudent(student.getRollId().toString())).withRel(LinkRelation.of(HttpMethod.DELETE.name())));

        return new ResponseEntity<>(student, HttpStatus.OK);


    }

    @DeleteMapping(path = "/student/{id}")
    public HttpEntity<?> deleteStudent(@PathVariable("id") String rollId) {

        if (studentDataService.studentExists(rollId)) {
            studentDataService.deleteStudent(rollId);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

}

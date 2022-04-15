package com.example.practicetask.web;


import com.example.practicetask.domain.Student;
import com.example.practicetask.exception.UserNotFoundException;
import com.example.practicetask.services.StudentInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentInterfaceImpl service;

    @GetMapping("/students")
    public List<Student> retrieveAllStudents(){

        List<Student> student = service.findAll();

        if(student==null)
            throw new UserNotFoundException("No Student Found");


        return student;
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable int id){
        Student student = service.findOne(id);

        if(student==null)
            throw new UserNotFoundException("id-"+ id);


        return student;

    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        Student savedStudent = service.save(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStudent.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/students/{id}")
    public void deleteUser(@PathVariable int id){
        Student student = service.deleteById(id);

        if(student==null)
            throw new UserNotFoundException("id-"+ id);
    }

}

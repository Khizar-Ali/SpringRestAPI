package com.example.practicetask.web;

import com.example.practicetask.domain.Course;
import com.example.practicetask.domain.Student;
import com.example.practicetask.services.CoursesInterfaceImpl;
import com.example.practicetask.services.StudentInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    private CoursesInterfaceImpl service;

    @GetMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return service.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course retrieveCourses(@PathVariable int id) {
        Course course = service.findOne(id);

      /*  if(user==null)
            throw new UserNotFoundException("id-"+ id);*/


        return course;

    }

    @PostMapping("/courses")
    public ResponseEntity<Object> createCourse(@RequestBody Course course) {
        Course savedCourse = service.save(course);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCourse.getCourseId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        Course course = service.deleteById(id);

        /*if(student==null)
            throw new UserNotFoundException("id-"+ id);*/
    }
}
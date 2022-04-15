package com.example.practicetask.repo;

import com.example.practicetask.domain.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentInterface {
    public List<Student> findAll ();
    public Student save(Student student);
    public Student findOne(int id);
    public Student deleteById(int id);

}

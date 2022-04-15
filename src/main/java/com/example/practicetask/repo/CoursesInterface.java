package com.example.practicetask.repo;


import com.example.practicetask.domain.Course;

import java.util.List;

public interface CoursesInterface {
    public List<Course> findAll ();
    public Course save(Course course);
    public Course findOne(int id);
    public Course deleteById(int id);


}

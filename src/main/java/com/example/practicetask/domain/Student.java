package com.example.practicetask.domain;

import java.util.Set;

public class Student extends People{
    private Integer id;
    private Set<Course> courseSet;

    public Student(String name, int age, String address, Integer id, Set<Course> courseSet) {
        super(name, age, address);
        this.id = id;
        this.courseSet = courseSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", courseSet=" + courseSet +
                '}';
    }
}

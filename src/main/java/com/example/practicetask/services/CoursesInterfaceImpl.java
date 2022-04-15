package com.example.practicetask.services;

import com.example.practicetask.domain.Course;
import com.example.practicetask.repo.CoursesInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CoursesInterfaceImpl implements CoursesInterface {
    private static List<Course> courses = new ArrayList<>();

    private static int studentCount = 3;



    public List<Course> findAll (){
        return courses;
    }
    public Course save(Course course){
        if(course.getCourseId()==null){
            course.setCourseId(++studentCount);
            //System.out.println(studentCount);
        }
        courses.add(course);
        return course;
    }

    public Course findOne(int id){
        for(Course course: courses){
            if(course.getCourseId()==id){
                return course;
            }
        }
        return null;
    }

    public Course deleteById(int id){
        Iterator<Course> iterator = courses.iterator();
        while(iterator.hasNext()){
            Course course = iterator.next();
            if(course.getCourseId() == id){
                iterator.remove();
                return course;
            }
        }
        return null;
    }

}

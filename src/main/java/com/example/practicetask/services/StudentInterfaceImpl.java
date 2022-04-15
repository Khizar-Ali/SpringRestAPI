package com.example.practicetask.services;

import com.example.practicetask.domain.Course;
import com.example.practicetask.domain.Student;
import com.example.practicetask.repo.StudentInterface;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentInterfaceImpl implements StudentInterface {
    private static List<Student> students = new ArrayList<>();

    private static int studentCount = 3;

    static{
        Set<Course> courseSet = new HashSet<>();
        courseSet.add(new Course(1,"Machine Learning", 3));
        students.add(new Student("khizar",23,"Address",2,courseSet));
    }


    public List<Student> findAll (){
        return students;
    }
    public Student save(Student student){
        if(student.getId()==null){
            student.setId(++studentCount);
        }
        students.add(student);
        return student;
    }

    public Student findOne(int id){
        for(Student student: students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

    public Student deleteById(int id){
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.getId() == id){
                iterator.remove();
                return student;
            }
        }
        return null;
    }





}

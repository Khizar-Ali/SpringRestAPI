package com.example.practicetask.services;

import com.example.practicetask.domain.Course;
import com.example.practicetask.domain.Employee;
import com.example.practicetask.domain.Employee;
import com.example.practicetask.repo.EmployeeInterface;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeInterfaceImpl implements EmployeeInterface {
    private static List<Employee> employees = new ArrayList<>();

    private static int employeeCount = 3;


    public List<Employee> findAll (){
        return employees;
    }
    public Employee save(Employee employee){
        if(employee.getEmpID()==null){
            employee.setEmpID(++employeeCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee findOne(int id){
        for(Employee employee: employees){
            if(employee.getEmpID()==id){
                return employee;
            }
        }
        return null;
    }

    public Employee deleteById(int id){
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getEmpID() == id){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }

}

package com.example.practicetask.repo;

import com.example.practicetask.domain.Employee;

import java.util.List;

public interface EmployeeInterface {
    public List<Employee> findAll ();
    public Employee save(Employee employee);
    public Employee findOne(int id);
    public Employee deleteById(int id);
}

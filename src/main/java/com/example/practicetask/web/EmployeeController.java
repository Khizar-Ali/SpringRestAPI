package com.example.practicetask.web;

import com.example.practicetask.domain.Employee;
import com.example.practicetask.exception.UserNotFoundException;
import com.example.practicetask.services.EmployeeInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeInterfaceImpl service;

    @GetMapping("/employee")
    public List<Employee> retrieveAllEmployee() {

        List<Employee> employees = service.findAll();

        if(employees.isEmpty())
            throw new UserNotFoundException("No Employee Found");

        return service.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee retrieveEmployee(@PathVariable int id) {
        Employee employee = service.findOne(id);

       if(employee==null)
            throw new UserNotFoundException("id-"+ id);


        return employee;

    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createCourse(@RequestBody Employee employee) {
        Employee savedEmployee = service.save(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getEmpID())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteCourse(@PathVariable int id) {
        Employee employee = service.deleteById(id);

        if(employee==null)
            throw new UserNotFoundException("id-"+ id);
    }
}

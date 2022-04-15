package com.example.practicetask.domain;

public class Employee extends People {
    private Integer empID;
    private double Salary;

    public Employee(String name, int age, String address, Integer empID, double salary) {
        super(name, age, address);
        this.empID = empID;
        Salary = salary;
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

}

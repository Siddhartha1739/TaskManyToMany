package com.example.EmployeeDatabase.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES_prjct")
public class Employee {
    @Id
    private int empId;
    private String firstName;
    private String lastName;
    private String role;
    private int salary;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
//    @JoinTable(name = "Employee_Project", joinColumns = @JoinColumn(name = "empId"),
//            inverseJoinColumns = @JoinColumn(name = "prjctid"))
    private List<Project> projects=new ArrayList<>();
    // Constructors
    public Employee() {
        super();
    }

    public Employee(int empId, String firstName, String lastName, String role, int salary, List<Project> projects) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.projects = projects;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }
}


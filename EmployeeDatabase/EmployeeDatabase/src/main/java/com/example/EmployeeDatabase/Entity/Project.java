package com.example.EmployeeDatabase.Entity;


import com.example.EmployeeDatabase.Model.EmployeeModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECT_Emp")
public class Project {
    @Id
    private int prjctid;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "Employee_Project", joinColumns = @JoinColumn(name = "prjctid"),
            inverseJoinColumns = @JoinColumn(name = "empId"))
    private List<Employee> employees=new ArrayList<>();

    public Project() {
    }

    public Project(int prjctid, String name, List<Employee> employees) {
        this.prjctid = prjctid;
        this.name = name;
        this.employees = employees;
    }

    public int getPrjctid() {
        return prjctid;
    }

    public void setPrjctid(int prjctid) {
        this.prjctid = prjctid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "prjctid=" + prjctid +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}

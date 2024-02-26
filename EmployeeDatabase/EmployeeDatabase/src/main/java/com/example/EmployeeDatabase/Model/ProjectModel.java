package com.example.EmployeeDatabase.Model;

import lombok.*;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectModel {
    private int prjctid;
    private String name;
    private List<EmployeeModel> employees;

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

    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeModel> employees) {
        this.employees = employees;
    }
}

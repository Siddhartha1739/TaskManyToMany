package com.example.EmployeeDatabase.Model;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeModel {
    private int empId;

    private String firstName;

    private String lastName;

    private String role;

    private int salary;
    private List<ProjectModel> projects;

}

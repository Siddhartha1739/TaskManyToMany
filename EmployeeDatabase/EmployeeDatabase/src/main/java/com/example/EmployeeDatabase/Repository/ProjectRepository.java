package com.example.EmployeeDatabase.Repository;

import com.example.EmployeeDatabase.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}

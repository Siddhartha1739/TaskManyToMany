package com.example.EmployeeDatabase.Repository;



import com.example.EmployeeDatabase.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
}

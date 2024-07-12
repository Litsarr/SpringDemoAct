package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByRole(String role);

    @Query(value = "SELECT * FROM Employee WHERE name = ?1", nativeQuery = true)
    List<Employee> findByNameNative(String name);
}

package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(final EmployeeRepository repository){
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public List<Employee> getAllEmployeesByName(String name) {
        return repository.findByNameNative(name);
    }

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

package com.example.jdbc.service;

import com.example.jdbc.model.Employee;
import com.example.jdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee getEmployeeById(Long id) {
        if (id == null) {
            return null;
        }
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public String updateEmployee(Long id, Employee employee) {
        return employeeRepository.updateEmployee(id, employee);
    }

    public String deleteEmployee(Long id) {
        return employeeRepository.deleteEmployee(id);
    }
}

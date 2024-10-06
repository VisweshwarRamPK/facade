package com.example.jdbc.facade;

import com.example.jdbc.model.Employee;
import com.example.jdbc.service.EmployeeService;
import com.example.jdbc.util.JsonToXmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;


    private final JsonToXmlConverter jsonToXmlConverter = JsonToXmlConverter.getInstance();

    public String createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public String updateEmployee(Long id, Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    public String deleteEmployee(Long id) {
        return employeeService.deleteEmployee(id);
    }

    public String convertJsonToXml(String json) throws IOException {
        return jsonToXmlConverter.convertJsonToXml(json);
    }

    public String convertXmlToJson(String xml) throws IOException {
        return jsonToXmlConverter.convertXmlToJson(xml);
    }
}

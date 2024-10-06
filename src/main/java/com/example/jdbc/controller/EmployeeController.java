package com.example.jdbc.controller;

import com.example.jdbc.facade.EmployeeFacade;
import com.example.jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error: " + bindingResult.getFieldError().getDefaultMessage());
        }
        String result = employeeFacade.createEmployee(employee);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeFacade.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeFacade.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Error: " + bindingResult.getFieldError().getDefaultMessage());
        }
        String result = employeeFacade.updateEmployee(id, employee);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String result = employeeFacade.deleteEmployee(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/convert")
    public ResponseEntity<String> convertJsonToXml(@RequestBody String json) {
        try {
            String xml = employeeFacade.convertJsonToXml(json);
            return ResponseEntity.ok(xml);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error converting JSON to XML: " + e.getMessage());
        }
    }

    @PostMapping("/convert/xml")
    public ResponseEntity<String> convertXmlToJson(@RequestBody String xml) {
        try {
            String json = employeeFacade.convertXmlToJson(xml);
            return ResponseEntity.ok(json);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error converting XML to JSON: " + e.getMessage());
        }
    }
}
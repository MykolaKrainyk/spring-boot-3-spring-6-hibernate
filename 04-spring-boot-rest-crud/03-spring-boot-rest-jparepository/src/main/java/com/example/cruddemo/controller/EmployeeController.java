package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.exception.EmployeeNotFoundException;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        // just in case they pass an id in json ... set id to 0
        // this is to force a save of new item ... instead of update
        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        employeeService.delete(employee);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse
                .builder(exception, HttpStatus.NOT_FOUND, exception.getMessage()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}

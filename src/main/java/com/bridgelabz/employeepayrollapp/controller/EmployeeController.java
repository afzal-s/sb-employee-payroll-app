package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/home")
public class EmployeeController {

    @GetMapping(value = {"", "/", "/greet"})
    public String greeting() {
        return "Welcome To Employee Payroll Application.";
    }

    @GetMapping("/employees")
    public ResponseEntity<String> fetchAllEmployees() {
        return new ResponseEntity<String>("Get All Employee Payroll Data", HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<String> fetchEmployeeById(@PathVariable long id) {
        return new ResponseEntity<String>("Get Employee Payroll Data For ID: " + id, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<String>("Created Employee Payroll Data For: " + employeeDTO, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
        return new ResponseEntity<String>("Updated Employee Payroll Data For ID: " + id, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long id) {
        return new ResponseEntity<String>("Deleted Employee Payroll Data For ID: " + id, HttpStatus.OK);
    }
}

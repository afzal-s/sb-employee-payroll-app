package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
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
    public ResponseEntity<ResponseDTO> fetchAllEmployees() {
        EmployeeDTO employeeData = new EmployeeDTO("Sohail", 30000);
        Employee employee = new Employee(1, employeeData);
        ResponseDTO responseDTO = new ResponseDTO("Get List Of Employees Payroll Data Successful", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponseDTO> fetchEmployeeById(@PathVariable long id) {
        EmployeeDTO employeeData = new EmployeeDTO("Sohail", 30000);
        Employee employee = new Employee(1, employeeData);
        ResponseDTO responseDTO = new ResponseDTO("Get Employee Payroll Data For ID Successful", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(1, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successful", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
        Employee employee = new Employee(1, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successful", employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted Employee Payroll Data Successful",
                "Deleted Id: " + id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

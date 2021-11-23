package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/home")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = {"", "/", "/greet"})
    public String greeting() {
        return "Welcome To Employee Payroll Application.";
    }

    @GetMapping("/employees")
    public ResponseEntity<ResponseDTO> fetchAllEmployeesData() {
        List<Employee> employeesDataList = employeeService.fetchAllEmployeesData();
        ResponseDTO responseDTO = new ResponseDTO("Get List Of Employees Payroll Data Successful", employeesDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponseDTO> fetchEmployeesDataById(@PathVariable long id) {
        Employee employeesData = employeeService.fetchEmployeesDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Employee Payroll Data For ID Successful", employeesData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<ResponseDTO> addEmployeeData(@RequestBody EmployeeDTO employeeDTO) {
        Employee employeeData = employeeService.addEmployeeData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successful", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeeDataById(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
        Employee employeeData = employeeService.updateEmployeeData(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successful", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeeDataById(@PathVariable long id) {
        employeeService.deleteEmployeeDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Employee Payroll Data Successful",
                "Deleted Id: " + id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}

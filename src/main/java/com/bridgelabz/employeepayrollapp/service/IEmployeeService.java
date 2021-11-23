package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> fetchAllEmployeesData();
    Employee fetchEmployeesDataById(String token);
    Employee addEmployeeData(EmployeeDTO employeeDTO);
    Employee updateEmployeeData(String token, EmployeeDTO employeeDTO);
    void deleteEmployeeDataById(String id);
}

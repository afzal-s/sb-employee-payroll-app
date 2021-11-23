package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> fetchAllEmployeesData();
    Employee fetchEmployeesDataById(long id);
    Employee addEmployeeData(EmployeeDTO employeeDTO);
    Employee updateEmployeeData(long id, EmployeeDTO employeeDTO);
    void deleteEmployeeDataById(long id);
}

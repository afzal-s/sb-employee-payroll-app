package com.bridgelabz.employeepayrollapp.service.serviceimpl;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.IEmployeeRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;
import com.bridgelabz.employeepayrollapp.util.UToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    UToken uToken;

    @Override
    public List<Employee> fetchAllEmployeesData() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeesDataById(String token) {
        return employeeRepository.findById(uToken.decodeToken(token))
                .orElseThrow(() -> new EmployeePayrollException("Employee With employeeId: " + uToken.decodeToken(token) + " does not exists"));
    }

    @Override
    public Employee addEmployeeData(@RequestBody EmployeeDTO employeeDTO) {
        Employee employeeData = new Employee(employeeDTO);
        return employeeRepository.save(employeeData);
    }

    @Override
    public Employee updateEmployeeData(@RequestHeader String token, @RequestBody EmployeeDTO employeeDTO) {
        Employee employeeData = this.fetchEmployeesDataById(token);
        employeeData.updateEmployeeData(employeeDTO);
        return employeeRepository.save(employeeData);
    }

    @Override
    public void deleteEmployeeDataById(String token) {
        Employee employeeData = this.fetchEmployeesDataById(token);
        employeeRepository.delete(employeeData);
    }
}

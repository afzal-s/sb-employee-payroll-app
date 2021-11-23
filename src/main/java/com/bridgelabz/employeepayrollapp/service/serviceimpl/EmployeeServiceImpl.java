package com.bridgelabz.employeepayrollapp.service.serviceimpl;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private List<Employee> employeeDataList = new ArrayList<>();

    @Override
    public List<Employee> fetchAllEmployeesData() {
        return employeeDataList;
    }

    @Override
    public Employee fetchEmployeesDataById(long id) {
        return employeeDataList.stream().filter(employee ->
                employee.getId() == id).findFirst().get();
    }

    @Override
    public Employee addEmployeeData(EmployeeDTO employeeDTO) {
        Employee employeeData = new Employee(employeeDataList.size() + 1, employeeDTO);
        employeeDataList.add(employeeData);
        return employeeData;
    }

    @Override
    public Employee updateEmployeeData(long id, EmployeeDTO employeeDTO) {
        Employee employeeData = this.fetchEmployeesDataById(id);

        if (employeeData != null) {
            employeeData.setName(employeeDTO.getName());
            employeeData.setSalary(employeeDTO.getSalary());
            employeeDataList.set((int) (id - 1), employeeData);
        }
        return employeeData;

    }

    @Override
    public void deleteEmployeeDataById(long id) {
        employeeDataList.removeIf(employee -> employee.getId() == id);
    }
}

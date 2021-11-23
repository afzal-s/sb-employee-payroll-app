package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Employee {
    private long id;
    private String name;
    private long salary;

    public Employee(long id, EmployeeDTO employeeData) {
        this.id = id;
        this.name = employeeData.name;
        this.salary = employeeData.salary;
    }
}

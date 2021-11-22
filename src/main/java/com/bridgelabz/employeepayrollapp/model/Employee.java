package com.bridgelabz.employeepayrollapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Employee {
    private long id;
    private String name;
    private long salary;
}

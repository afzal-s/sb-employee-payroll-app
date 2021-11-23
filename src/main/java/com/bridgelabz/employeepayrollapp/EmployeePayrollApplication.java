package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.bridgelabz.employeepayrollapp.repository")
public class EmployeePayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollApplication.class, args);
    }

}

package com.sridharan.entityrelation.controller;

import com.sridharan.entityrelation.model.Employee;
import com.sridharan.entityrelation.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addemployee")
    public Employee addEmployee(@RequestBody Employee employee){
        log.info("Inside Employee Added");
        return service.createEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        log.info("Inside Get all Employees");
        return service.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        log.info("Inside Get Employee with id");
        return service.getEmployeeById(id);
    }

    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        log.info("Inside Update the Employee");
        employee.setEmployeeId(id);
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable long id){
        log.info("Inside Delete Employee");
        return service.deleteemployee(id);
    }
}

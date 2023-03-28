package com.sridharan.entityrelation.service;

import com.sridharan.entityrelation.model.Employee;
import com.sridharan.entityrelation.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee){
        log.info("Employee with Id: {} is saved",employee.getEmployeeId());
        return employeeRepository.save(employee);
    }
    public List<Employee> getEmployees(){
        log.info("Getting All Employee");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        log.info("Getting Employee with Id: {}", id);
        return employeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee employee){
        Employee OldEmployee = employeeRepository.findById(employee.getEmployeeId()).get();
        OldEmployee.setEmployeeName(employee.getEmployeeName());
        log.info("Updating employee with Id: {}",employee.getEmployeeId());
        return employeeRepository.save(OldEmployee);
    }

    public String deleteemployee(long id){
        employeeRepository.deleteById(id);
        log.info("Deleting employee with Id: {}",id);
        return "employee Removed with id: "+id;
    }
}

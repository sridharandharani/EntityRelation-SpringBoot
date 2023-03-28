package com.sridharan.entityrelation.repository;

import com.sridharan.entityrelation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}

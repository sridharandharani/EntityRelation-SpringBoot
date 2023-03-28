package com.sridharan.entityrelation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectName;

    @ManyToMany
    @JoinTable(
            name = "employee_enrolled",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> enrolledEmployees = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "managerId")
    private Manager manager;

    public void enrollEmployee(Employee employee) {
        enrolledEmployees.add(employee);
    }

    public void assignManager(Manager manager) {
        this.manager = manager;
    }

}

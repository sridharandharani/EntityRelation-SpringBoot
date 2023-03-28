package com.sridharan.entityrelation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledEmployees")
    private List<Project> projects = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}

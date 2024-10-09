package com.employee.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    private String employeeName;
    private String employeePhone;
    private String employeeAddress;
    private String employeeGender;
    private String employeeDepartment;
    @ElementCollection
    private List<String> employeeSkills;

}

package com.employee.crud.dao;

import com.employee.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}

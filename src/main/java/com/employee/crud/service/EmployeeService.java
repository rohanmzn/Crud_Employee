package com.employee.crud.service;

import com.employee.crud.dao.EmployeeDao;
import com.employee.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public Employee saveEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }


    public Employee getEmployee(Integer employeeId) {
        return employeeDao.findById(employeeId).orElse(null);
    }

    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteById(employeeId);
    }

    public Employee updateEmployee(Employee employee) {
        employeeDao.findById(employee.getEmployeeId()).orElseThrow();
        return employeeDao.save(employee);
    }
}

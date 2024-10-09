package com.employee.crud.controller;

import com.employee.crud.entity.Employee;
import com.employee.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //add  employees
    @PostMapping("save")
    public Employee saveEmployee(@RequestBody Employee employee){
//        System.out.println("Controller:"+employee.toString());
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("get")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("get/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @DeleteMapping("delete/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
}

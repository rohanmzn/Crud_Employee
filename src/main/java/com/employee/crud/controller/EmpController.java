package com.employee.crud.controller;

import com.employee.crud.entity.Employee;
import com.employee.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

        private static final List<String> DEPARTMENTS = Arrays.asList("HR", "IT", "Finance", "Sales", "Marketing");
        private static final List<String> SKILLS = Arrays.asList("Java", "Python", "JavaScript", "SQL");

    // Render the form to add an employee
    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", DEPARTMENTS); // Add department list to model
        model.addAttribute("skills", SKILLS); // Add skills list
        return "add_employee";
    }

    // Add employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/emp/get";
    }

    // Display all employees
    @GetMapping("/get")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "list_employees";
    }

    // Display employee details by ID
    @GetMapping("/get/{employeeId}")
    public String getEmployee(@PathVariable Integer employeeId, Model model) {
        Employee employee = employeeService.getEmployee(employeeId);
        model.addAttribute("employee", employee);
        return "view_employee";  // Thymeleaf template name (view_employee.html)
    }

    // Render the form to update an employee
    @GetMapping("/update/{employeeId}")
    public String showUpdateEmployeeForm(@PathVariable Integer employeeId, Model model) {
        System.out.println("Fetching employee with ID: " + employeeId);
        Employee employee = employeeService.getEmployee(employeeId);

        if (employee == null) {
            // Optionally return an error view or redirect
            return "redirect:/emp/get"; // or return an error page
        }

        model.addAttribute("employee", employee);
        model.addAttribute("departments", DEPARTMENTS); // Add departments to the model
        model.addAttribute("skills", SKILLS); // Add skills to the model
        return "update_employee";
    }

    // Update employee
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/emp/get";
    }

    // Delete employee
    @GetMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/emp/get";
    }
}

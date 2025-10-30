package com.fpt.salarymanagement.controller;

import com.fpt.salarymanagement.entity.Employee;
import com.fpt.salarymanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeViewController {

    private final EmployeeService employeeService;

    @GetMapping
    public String listEmployees(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("employees", employeeService.searchEmployees(keyword));
        model.addAttribute("keyword", keyword);
        return "employees";
    }

    @GetMapping("/new")
    public String newEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_form";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee e = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
        model.addAttribute("employee", e);
        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}

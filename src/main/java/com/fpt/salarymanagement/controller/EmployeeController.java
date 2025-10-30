package com.fpt.salarymanagement.controller;

import com.fpt.salarymanagement.entity.Employee;
import com.fpt.salarymanagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;

    // ✅ Lấy danh sách tất cả nhân viên
//    GET /api/v1/employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam(required = false) String keyword) {
        return ResponseEntity.ok(employeeService.searchEmployees(keyword));
    }

    // ✅ Lấy nhân viên theo ID
//    GET /api/v1/employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Tạo mới nhân viên
//    POST /api/v1/employees
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee saved = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(saved);
    }

    // ✅ Cập nhật nhân viên
//    PUT /api/v1/employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee updated) {

        return employeeService.getEmployeeById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setEmail(updated.getEmail());
                    existing.setDepartment(updated.getDepartment());
                    existing.setPosition(updated.getPosition());
                    existing.setBasicSalary(updated.getBasicSalary());
                    existing.setAllowance(updated.getAllowance());
                    existing.setTotalSalary(updated.getBasicSalary() + updated.getAllowance());
                    Employee saved = employeeService.saveEmployee(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Xóa nhân viên
//    DELETE /api/v1/employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}

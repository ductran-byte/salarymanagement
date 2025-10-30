package com.fpt.salarymanagement.service;

import com.fpt.salarymanagement.entity.Employee;
import com.fpt.salarymanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // ✅ Lấy danh sách tất cả nhân viên
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Thêm mới hoặc cập nhật nhân viên
    public Employee saveEmployee(Employee employee) {
        // Auto-calculate totalSalary nếu cần
        employee.setTotalSalary(employee.getBasicSalary() + employee.getAllowance());
        return employeeRepository.save(employee);
    }

    // ✅ Tìm nhân viên theo ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // ✅ Xóa nhân viên
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // ✅ Tìm kiếm nhân viên theo từ khóa (tên / email)
    public List<Employee> searchEmployees(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return employeeRepository.findAll();
        }
        return employeeRepository.searchByKeyword(keyword);
    }
}

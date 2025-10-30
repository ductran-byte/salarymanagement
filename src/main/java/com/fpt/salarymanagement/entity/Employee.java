package com.fpt.salarymanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Employee name is required")
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    @Email(message = "Invalid email format")
    private String email;

    @Column(length = 50)
    private String department;

    @Column(length = 50)
    private String position;

    @Column(nullable = false)
    @Min(value = 0, message = "Basic salary must be positive")
    private Double basicSalary;

    @Column(nullable = false)
    @Min(value = 0, message = "Allowance must be positive")
    private Double allowance;

    @Column(nullable = false)
    private Double totalSalary;

    // ✅ Khi lưu, có thể tự tính totalSalary nếu chưa được gán
    @PrePersist
    @PreUpdate
    public void calculateTotalSalary() {
        if (basicSalary != null && allowance != null) {
            this.totalSalary = basicSalary + allowance;
        }
    }
}

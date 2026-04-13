package com.hrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Salary Entity
 */
@Entity
@Table(name = "sal_salary")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_id", nullable = false)
    private Long empId;

    @Column(name = "salary_month", length = 10)
    private String salaryMonth;

    @Column(name = "base_salary")
    private BigDecimal baseSalary;

    @Column(name = "bonus")
    private BigDecimal bonus;

    @Column(name = "deduction")
    private BigDecimal deduction;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "actual_salary")
    private BigDecimal actualSalary;

    @Column(name = "remark", length = 255)
    private String remark;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
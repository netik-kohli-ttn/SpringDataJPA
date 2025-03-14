package com.netik.SpringJPA2;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "employee_table")
public class Employee {
    @Embedded
    Salary salaryEmbed;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_first_name")
    private String firstName;

    @Column(name = "emp_last_name")
    private String lastName;

    @Column(name = "emp_salary")
    private Double salary;

    @Column(name = "emp_age")
    private Integer age;

}

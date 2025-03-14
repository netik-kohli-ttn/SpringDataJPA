package com.netik.SpringJPA2;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Salary {
    private Double basicSalary;
    private Double bonusSalary;
    private Double taxAmount;
    private Double specialAllowanceSalary;
}

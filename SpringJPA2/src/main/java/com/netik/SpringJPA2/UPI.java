package com.netik.SpringJPA2;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("UPI")
public class UPI extends Employee {
    int UpiID;
}




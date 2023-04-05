package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.AvailabilityEnum;
import com.csidigital.rh.shared.enumeration.ContractType;
import com.csidigital.rh.shared.enumeration.Experience;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministrativeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    private double currentSalary;
    private double expectedSalary;
    @Enumerated(EnumType.STRING)
    private AvailabilityEnum availability;
    private LocalDate availabilityDate;
    @Enumerated(EnumType.STRING)
    private Experience experience;

}

package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.ContractBenifitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BenefitRC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortDescription;
    private String description;
    @Enumerated(EnumType.STRING)
    private ContractBenifitType contractBenifitType;
}

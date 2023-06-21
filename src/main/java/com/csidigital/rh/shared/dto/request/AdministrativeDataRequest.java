package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.Evaluation;
import com.csidigital.rh.shared.enumeration.AvailabilityEnum;
import com.csidigital.rh.shared.enumeration.ContractTitle;
import com.csidigital.rh.shared.enumeration.ContractType;
import com.csidigital.rh.shared.enumeration.Experience;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AdministrativeDataRequest {

    @Enumerated(EnumType.STRING)
    private ContractTitle contractTitle;
    private double currentSalary;
    private double expectedSalary;
    private AvailabilityEnum availability;
    private LocalDate availabilityDate;
    private Experience experience;
    private Long employeeNum;

}

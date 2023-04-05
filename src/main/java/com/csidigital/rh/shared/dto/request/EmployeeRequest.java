package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EmployeeRequest {
    private String lastName;
    private String firstName;
    private Civility civility;
    private Title title;
    private EmployeeType employeeType;
    private LocalDate birthDate;
    private String emailOne;
    private String emailTwo;
    private Integer phoneNumberOne;
    private Integer phoneNumberTwo;
    private String adress;
    private Integer postCode;
    private Integer city;
    private Country country;
    private MaritalSituation maritalSituation;
    private Integer recommendationType ;
    private Integer experience ;
    private String experienceDetails ;

    private Provenance provenance;
    private String employeeFirstName;
    private String employeeLastName;
    private String EmployeeSerialNumber;
    private Long AssOfferCandidateId;

    private EmployeeStatus employeeStatus;
}

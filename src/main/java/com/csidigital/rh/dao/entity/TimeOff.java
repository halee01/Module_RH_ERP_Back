package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.ExternalTimeOffType;
import com.csidigital.rh.shared.enumeration.RequestStatus;
import com.csidigital.rh.shared.enumeration.TimeOffType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TimeOff {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    @Enumerated(EnumType.STRING)
    private TimeOffType timeOffType;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String timeOffPeriod;
    private String comment;
    private LocalDate requestInputDate;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    private LocalDate validationDate;
    @Enumerated(EnumType.STRING)
    private ExternalTimeOffType externalTimeOffType;


}

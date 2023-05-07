package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;

@Data

public class CertificationRequest {
    private String certificationTitle;
    private LocalDate certificationObtainedDate;
    private Long technicalFileId ;
}

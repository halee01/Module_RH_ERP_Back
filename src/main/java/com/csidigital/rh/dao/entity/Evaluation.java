package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Evaluation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "globalAppreciation")
    private Integer globalAppreciation;
    private String evaluationRef;
    private LocalDate evaluationDate;

    @ManyToOne()
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @OneToMany(mappedBy = "evaluation" , cascade = CascadeType.ALL)
    private List<Interview> interviews;

}



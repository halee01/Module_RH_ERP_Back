package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Interview {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private String duration;
    private String comment;
    private String globalMark;
    private String interviewerName;
    private String interviewerEmail;
    private String interviewerPhoneNumber;
    private String interviewPlace;

    @Enumerated(EnumType.STRING)
    private InterviewLocation interviewLocation ;

    @Enumerated(EnumType.STRING)
    private InterviewType interviewType;

    @Enumerated(EnumType.STRING)
    private InterviewMode interviewMode;

    @Enumerated(EnumType.STRING)
    private InterviewStatus interviewStatus;


    @OneToMany(mappedBy = "interview")
    private List<AssQuestionInterview> assQuestionInterviewList;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "interview_question_type",
            joinColumns = @JoinColumn(name = "interview_id"),
            inverseJoinColumns = @JoinColumn(name = "question_type_id"))
    private List<QuestionType> questionTypeList;




}



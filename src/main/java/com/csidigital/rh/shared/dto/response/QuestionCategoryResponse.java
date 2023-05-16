package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Question;
import com.csidigital.rh.shared.enumeration.ExperienceLevel;
import lombok.Data;

import java.util.List;
@Data
public class QuestionCategoryResponse {
    private Long Id ;
    private String name ;
    private List<Question> questions;
    private ExperienceLevel level ;
}

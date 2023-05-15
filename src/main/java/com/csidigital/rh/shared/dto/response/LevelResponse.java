package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.QuestionCategory;
import jakarta.persistence.OneToMany;

import java.util.List;

public class LevelResponse {
    private Long id;
    private String name ;
    private List<QuestionCategory> questionCategories;
}

package com.csidigital.rh.management.controller;
import com.csidigital.rh.management.service.impl.QuestionTypeImpl;
import com.csidigital.rh.shared.dto.request.QuestionTypeRequest;
import com.csidigital.rh.shared.dto.response.QuestionCategoryResponse;
import com.csidigital.rh.shared.dto.response.QuestionTypeResponse;
import com.csidigital.rh.shared.dto.response.TechnicalFileResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/QuestionType")
public class QuestionTypeController {
    @Autowired
    private QuestionTypeImpl questionTypeImpl;

    @GetMapping("/getAll")
    public List<QuestionTypeResponse> getAllQuestionTypes() {
        return questionTypeImpl.getAllQuestionTypes();
    }

    @GetMapping("/getBy/{id}")
    public QuestionTypeResponse getQuestionTypeById(@PathVariable Long id){
        return questionTypeImpl.getQuestionTypeById(id);
    }


    @PostMapping("/add")
    public QuestionTypeResponse createQuestionType(@Valid @RequestBody QuestionTypeRequest questionTypeRequest){
        return questionTypeImpl.createQuestionType(questionTypeRequest);
    }

    @PutMapping("/update/{id}")
    public QuestionTypeResponse updateQuestionType(@Valid @RequestBody QuestionTypeRequest questionTypeRequest,
                                            @PathVariable Long id){
        return questionTypeImpl.updateQuestionType(questionTypeRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestionType(@PathVariable Long id){
        questionTypeImpl.deleteQuestionType(id);
    }

}

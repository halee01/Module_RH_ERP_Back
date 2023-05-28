package com.csidigital.rh.management.service.impl;


import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.QuestionCategory;
import com.csidigital.rh.dao.entity.QuestionType;
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.dao.repository.QuestionCategoryRepository;
import com.csidigital.rh.dao.repository.QuestionTypeRepository;
import com.csidigital.rh.management.service.QuestionTypeService;
import com.csidigital.rh.shared.dto.request.QuestionTypeRequest;
import com.csidigital.rh.shared.dto.response.QuestionCategoryResponse;
import com.csidigital.rh.shared.dto.response.QuestionTypeResponse;
import com.csidigital.rh.shared.dto.response.TechnicalFileResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class QuestionTypeImpl implements QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository ;
    @Autowired
    private QuestionCategoryRepository questionCategoryRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionTypeResponse createQuestionType(QuestionTypeRequest request) {
        //QuestionCategory questionCategory= questionCategoryRepository.findById(request.getQuestionCategoryNum()).orElseThrow();
        QuestionType questionType = modelMapper.map(request, QuestionType.class);
        //questionType.setQuestionCategory(questionCategory);
        QuestionType QuestionTypeSaved = questionTypeRepository.save(questionType);
        return modelMapper.map(QuestionTypeSaved, QuestionTypeResponse.class);
    }

    @Override
    public List<QuestionTypeResponse> getAllQuestionTypes() {
        List<QuestionType> questionType = questionTypeRepository.findAll();
        List<QuestionTypeResponse> questionTypeList = new ArrayList<>();


        for (QuestionType questionTypes: questionType) {
            QuestionTypeResponse response = modelMapper.map(questionTypes, QuestionTypeResponse.class);
            questionTypeList.add(response);}

        return questionTypeList;
    }

    @Override
    public QuestionTypeResponse getQuestionTypeById(Long id) {
        QuestionType questionType =questionTypeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("QuestionType with id " +id+ " not found"));
        QuestionTypeResponse questionTypeResponse = modelMapper.map(questionType, QuestionTypeResponse.class);
        return questionTypeResponse;
    }


    @Override
    public QuestionTypeResponse updateQuestionType(QuestionTypeRequest request, Long id) {
        QuestionType existingQuestionType = questionTypeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("QuestionType with id: " + id + " not found"));
        modelMapper.map(request, existingQuestionType);
        QuestionType savedQuestionType = questionTypeRepository.save(existingQuestionType);
        return modelMapper.map(savedQuestionType, QuestionTypeResponse.class);
    }

    @Override
    public void deleteQuestionType(Long id) {
        questionTypeRepository.deleteById(id);
    }
}

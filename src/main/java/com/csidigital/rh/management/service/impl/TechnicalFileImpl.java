package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.dao.repository.EmployeeRepository;
import com.csidigital.rh.dao.repository.SkillsRepository;
import com.csidigital.rh.dao.repository.TechnicalFileRepository;
import com.csidigital.rh.management.service.TechnicalFileService;
import com.csidigital.rh.shared.dto.request.SkillsRequest;
import com.csidigital.rh.shared.dto.request.TechnicalFileRequest;
import com.csidigital.rh.shared.dto.response.AdministrativeDataResponse;
import com.csidigital.rh.shared.dto.response.SkillsResponse;
import com.csidigital.rh.shared.dto.response.TechnicalFileResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
@Transactional
public class TechnicalFileImpl implements TechnicalFileService {
    @Autowired
    private TechnicalFileRepository technicalFileRepository;
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public TechnicalFileResponse createTechnicalFile(TechnicalFileRequest request) {
        Employee employee =  employeeRepository.findById(request.getEmployeeId()).orElseThrow();
        TechnicalFile technicalFile= modelMapper.map(request, TechnicalFile.class);
        List<Skills> skills = technicalFile.getSkills();
        List<Language> languages=technicalFile.getLanguages();
        List<Experience> experiences=technicalFile.getExperiences();
        List<Education> educations=technicalFile.getEducations();
        List<Certification> certifications=technicalFile.getCertifications();
        for(Skills skill : skills) {
            skill.setTechnicalFile(technicalFile);
        }
        for (Language language :languages ){
            language.setTechnicalFile(technicalFile);
        }
        for (Experience experience :experiences ){
            experience.setTechnicalFile(technicalFile);
        }
        for (Education education :educations ){
            education.setTechnicalFile(technicalFile);
        }
        for (Certification certification :certifications ){
            certification.setTechnicalFile(technicalFile);
        }
        technicalFile.setEmployee(employee);
        TechnicalFile technicalFileSaved = technicalFileRepository.save(technicalFile);
        return modelMapper.map(technicalFileSaved, TechnicalFileResponse .class);
    }

    @Override
    public List<TechnicalFileResponse> getAllTechnicalFiles() {
        List<TechnicalFile> technicalFiles = technicalFileRepository.findAll();
        List<TechnicalFileResponse> technicalFileResponseList = new ArrayList<>();

        for (TechnicalFile technicalFile : technicalFiles) {
            TechnicalFileResponse response = modelMapper.map(technicalFile, TechnicalFileResponse.class);
            technicalFileResponseList.add(response);
        }

        return technicalFileResponseList;
    }

    @Override
    public TechnicalFileResponse  getTechnicalFileById(Long id) {
        TechnicalFile technicalFile = technicalFileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TechnicalFile with id " + id + " not found"));
        TechnicalFileResponse  technicalFileResponse = modelMapper.map(technicalFile, TechnicalFileResponse .class);
        return technicalFileResponse;
    }
    @Override
    public List<Skills>  getTechnicalFileSkillsById(Long id) {
        TechnicalFile technicalFile = technicalFileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TechnicalFile with id " + id + " not found"));
        List<Skills> skills = technicalFile.getSkills();
        return skills ;
    }

    @Override
    public TechnicalFileResponse  updateTechnicalFile(TechnicalFileRequest request, Long id) {
        TechnicalFile existingTechnicalFile = technicalFileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TechnicalFile with id: " + id + " not found"));
        modelMapper.map(request, existingTechnicalFile);
        TechnicalFile savedTechnicalFile = technicalFileRepository.save(existingTechnicalFile);
        return modelMapper.map(savedTechnicalFile, TechnicalFileResponse .class);
    }

    @Override
    public void deleteTechnicalFile(Long id) {technicalFileRepository.deleteById(id);
    }
}

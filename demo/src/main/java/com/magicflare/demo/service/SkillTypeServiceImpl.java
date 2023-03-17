package com.magicflare.demo.service;

import com.magicflare.demo.dto.request.SkillTypeRequest;
import com.magicflare.demo.dto.response.SkillResponse;
import com.magicflare.demo.dto.response.SkillTypeResponse;
import com.magicflare.demo.exceptionhandler.exception.NoResourceFoundException;
import com.magicflare.demo.model.SkillEntity;
import com.magicflare.demo.model.SkillTypeEntity;
import com.magicflare.demo.repository.SkillEntityRepository;
import com.magicflare.demo.repository.SkillTypeEntityRepository;
import com.magicflare.demo.util.skillconverter.SkillConverter;
import com.magicflare.demo.util.skillconverter.SkillTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillTypeServiceImpl implements  SkillTypeService{

    @Autowired
    SkillTypeEntityRepository skillTypeEntityRepository;

    @Autowired
    SkillTypeConverter skillTypeConverter;

    @Autowired
    SkillConverter skillConverter;


    @Autowired
    SkillEntityRepository skillEntityRepository;

    @Override
    public SkillTypeResponse createSkillType(SkillTypeRequest skillRequest) {
        SkillTypeEntity skillType = skillTypeConverter.skillTypeEntityToSkillTypeRequest(skillRequest);

        SkillTypeEntity skill = skillTypeEntityRepository.save(skillType);
        return skillTypeConverter.skillTypeEntityToSkillTypeResponse(skill);
    }

    @Override
    public List<SkillTypeResponse> getSkillsTypeList() {

        List<SkillTypeEntity> skillTypeEntities = skillTypeEntityRepository.findAll();
        return skillTypeConverter.skillTypeEntityListToSkillTypeResponseList(skillTypeEntities);
    }

    @Override
    public List<SkillTypeResponse> getSkillsTypeListByPage(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public SkillTypeResponse getSkillTypeById(Integer skillTypeId) {
        SkillTypeEntity skillType = skillTypeEntityRepository.findById(skillTypeId).orElseThrow(() -> new NoResourceFoundException("Skill Type Not found for id "+skillTypeId));
        SkillTypeResponse skillTypeResponse = skillTypeConverter.skillTypeEntityToSkillTypeResponse(skillType);
        List<SkillEntity> skillList = skillEntityRepository.findBySkillType(skillType);
        List<SkillResponse> skillResponseList = skillConverter.skillEntityListToSkillResponseList(skillList);
        skillTypeResponse.setSkillList(skillResponseList);
        return skillTypeResponse;
    }

    @Override
    public SkillTypeResponse updateSkillTypeById(Integer skillTypeId, SkillTypeRequest skillTypeRequest) {
        SkillTypeEntity skillType = skillTypeEntityRepository.findById(skillTypeId).orElseThrow(() -> new NoResourceFoundException("Skill Type Not found for id "+skillTypeId));
        skillType.setSkillTypeName(skillType.getSkillTypeName());
        return skillTypeConverter.skillTypeEntityToSkillTypeResponse(skillTypeEntityRepository.save(skillType));
    }

    @Override
    public SkillTypeResponse deleteSkillTypeById(Integer skillTypeId) {
        SkillTypeEntity skillType = skillTypeEntityRepository.findById(skillTypeId).orElseThrow(() -> new NoResourceFoundException("Skill Type Not found for id "+skillTypeId));
        skillTypeEntityRepository.delete(skillType);
        return skillTypeConverter.skillTypeEntityToSkillTypeResponse(skillType);
    }
}

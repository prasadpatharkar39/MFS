package com.magicflare.demo.service;

import com.magicflare.demo.dto.request.SkillRequest;
import com.magicflare.demo.dto.request.SkillTypeRequest;
import com.magicflare.demo.dto.response.SkillResponse;
import com.magicflare.demo.dto.response.SkillTypeResponse;
import com.magicflare.demo.exceptionhandler.exception.NoResourceFoundException;
import com.magicflare.demo.model.SkillEntity;
import com.magicflare.demo.model.SkillTypeEntity;
import com.magicflare.demo.repository.SkillEntityRepository;
import com.magicflare.demo.repository.SkillTypeEntityRepository;
import com.magicflare.demo.util.skillconverter.SkillConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SkillServiceImpl implements  SkillService{

    @Autowired
    private SkillEntityRepository skillRepository;

    @Autowired
    private  SkillTypeEntityRepository skillTypeEntityRepository;
    @Autowired
    private  SkillConverter skillConverter;


    @Override
    public SkillResponse createSkill(SkillRequest skillRequest) {
        SkillConverter skillConverter = new SkillConverter();
        SkillEntity skillEntity = skillConverter.skillRequestToSkillEntity(skillRequest);
        SkillTypeEntity skillType = skillTypeEntityRepository.findById(skillRequest.getSkillTypeId()).orElseThrow(() -> new NoResourceFoundException("Skill type  Not found for id"+skillRequest.getSkillTypeId()));
        skillEntity.setSkillType(skillType);
        SkillEntity skill = skillRepository.save(skillEntity);
        return skillConverter.skillEntityToSkillResponse(skill);
    }

    @Override
    public List<SkillResponse> getSkillsList() {
        List<SkillEntity> skillsList = skillRepository.findAll();
        return  skillConverter.skillEntityListToSkillResponseList(skillsList);
    }

    @Override
    public List<SkillResponse> getSkillsListByPage(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public SkillResponse getSkillById(Integer skillId) {
        SkillEntity skill = skillRepository.findById(skillId).orElseThrow(() -> new NoResourceFoundException("Skill  Not found for id"+skillId));
        return skillConverter.skillEntityToSkillResponse(skill);
    }

    @Override
    public SkillResponse updateSkillById(Integer skillId, SkillRequest skillRequest) {
        SkillEntity skill = skillRepository.findById(skillId).orElseThrow(() -> new NoResourceFoundException("Skill  Not found for id"+skillId));
        skill.setSkillName(  skillRequest.getSkillName());

        return skillConverter.skillEntityToSkillResponse(skillRepository.save(skill));
    }

    @Override
    public SkillResponse deleteSkillById(Integer skillId) {
        SkillEntity skill = skillRepository.findById(skillId).orElseThrow(() -> new NoResourceFoundException("Skill Type Not found"));
        skillRepository.delete(skill);
        return skillConverter.skillEntityToSkillResponse(skill);
    }

}

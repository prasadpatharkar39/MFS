package com.magicflare.demo.util.skillconverter;

import com.magicflare.demo.dto.request.SkillTypeRequest;
import com.magicflare.demo.dto.response.SkillResponse;
import com.magicflare.demo.dto.response.SkillTypeResponse;
import com.magicflare.demo.model.SkillTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkillTypeConverter {
    public SkillTypeResponse skillTypeEntityToSkillTypeResponse(SkillTypeEntity skillType) {
        return SkillTypeResponse.builder()
                .id(skillType.getId())
                .skillTypeName(skillType.getSkillTypeName())
                .build();
    }

    public List<SkillTypeResponse> skillTypeEntityListToSkillTypeResponseList(List<SkillTypeEntity> skillTypeEntityList) {
        List<SkillTypeResponse> skillTypeResponseList = new ArrayList<>();
        for (SkillTypeEntity skillType : skillTypeEntityList) {
            skillTypeResponseList.add(skillTypeEntityToSkillTypeResponse(skillType));
        }
        return skillTypeResponseList;

    }

    public SkillTypeEntity skillTypeEntityToSkillTypeRequest(SkillTypeRequest skillTypeRequest) {
        return SkillTypeEntity.builder()
                .skillTypeName(skillTypeRequest.getSkillTypeName())
                .build();

    }


    List<SkillTypeEntity> skillTypeEntityListToSkillTypeRequestList(List<SkillTypeRequest> SkillTypeRequest) {
        List<SkillTypeEntity> skillTypeEntityList = new ArrayList<>();
        for (SkillTypeRequest skillTypeRequest : SkillTypeRequest) {
            skillTypeEntityList.add(skillTypeEntityToSkillTypeRequest(skillTypeRequest));
        }
        return skillTypeEntityList;

    }
}

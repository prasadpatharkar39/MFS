package com.magicflare.demo.util.skillconverter;

import com.magicflare.demo.dto.request.SkillRequest;
import com.magicflare.demo.dto.response.SkillResponse;
import com.magicflare.demo.dto.response.SkillTypeResponse;
import com.magicflare.demo.model.SkillEntity;
import com.magicflare.demo.model.SkillTypeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SkillConverter {
   public SkillEntity skillRequestToSkillEntity(SkillRequest request){
        return SkillEntity.builder()
                .skillName(request.getSkillName())
                .build();
    }




    public List<SkillEntity> skillRequestListToSkillEntityList(List<SkillRequest> skillRequestList) {
        List<SkillEntity> skillTypeResponseList = new ArrayList<>();
        for (SkillRequest skillRequest : skillRequestList) {
            skillTypeResponseList.add(skillRequestToSkillEntity(skillRequest));
        }
        return skillTypeResponseList;

    }



   public SkillResponse skillEntityToSkillResponse(SkillEntity skill){
        return  SkillResponse.builder().id(skill.getId())
                .skillName(skill.getSkillName())
                .skillType(new SkillTypeConverter().skillTypeEntityToSkillTypeResponse(skill.getSkillType()))
                .build();
    }


    public List<SkillResponse> skillEntityListToSkillResponseList(List<SkillEntity> skillEntities) {
        List<SkillResponse> skillResponseList = new ArrayList<>();
        for (SkillEntity skillRequest : skillEntities) {
            skillResponseList.add(skillEntityToSkillResponse(skillRequest));
        }
        return skillResponseList;

    }
}

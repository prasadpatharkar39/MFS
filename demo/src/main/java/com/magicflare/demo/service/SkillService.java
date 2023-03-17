package com.magicflare.demo.service;


import com.magicflare.demo.dto.request.SkillRequest;
import com.magicflare.demo.dto.response.SkillResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {

   SkillResponse createSkill(SkillRequest skillRequest);
List<SkillResponse> getSkillsList();
List<SkillResponse> getSkillsListByPage(int pageNumber,int pageSize);
SkillResponse getSkillById(Integer skillId);
SkillResponse updateSkillById(Integer skillId,SkillRequest skillRequest);
SkillResponse deleteSkillById(Integer skillId);


}

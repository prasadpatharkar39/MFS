package com.magicflare.demo.service;


import com.magicflare.demo.dto.request.SkillRequest;
import com.magicflare.demo.dto.request.SkillTypeRequest;
import com.magicflare.demo.dto.response.SkillResponse;
import com.magicflare.demo.dto.response.SkillTypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillTypeService {

   SkillTypeResponse createSkillType(SkillTypeRequest skillRequest);
List<SkillTypeResponse> getSkillsTypeList();
List<SkillTypeResponse> getSkillsTypeListByPage(int pageNumber,int pageSize);
SkillTypeResponse getSkillTypeById(Integer skillTypeId);
SkillTypeResponse updateSkillTypeById(Integer skillTypeId,SkillTypeRequest skillTypeRequest);
SkillTypeResponse deleteSkillTypeById(Integer skillTypeId);


}

package com.magicflare.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillTypeResponse {
    private  Integer id;
    private  String skillTypeName;
    private List<SkillResponse> skillList;
}

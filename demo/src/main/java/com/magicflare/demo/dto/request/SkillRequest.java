package com.magicflare.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillRequest {
    @JsonProperty(required = true)
    @NotNull(message = "skillTypeName Can not be Null")
    @NotBlank(message = "skillTypeName Value Not NotBlank")
private  String skillName;
    @JsonProperty(required = true)
    @NotNull(message = "skillTypeId Can not be Null")
    @NotBlank(message = "skillTypeId Value Not NotBlank")
    private  Integer skillTypeId;

}

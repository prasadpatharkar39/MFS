package com.magicflare.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillTypeRequest {
    @JsonProperty(required = true)
    @NotNull(message = "skillTypeName Not Found")
    @NotBlank(message = "skillTypeName Value Not NotBlank")
    private  String skillTypeName;
}

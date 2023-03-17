package com.magicflare.demo.controller;

import com.magicflare.demo.constants.ConstantsForApis;
import com.magicflare.demo.dto.request.SkillRequest;
import com.magicflare.demo.dto.request.SkillTypeRequest;
import com.magicflare.demo.service.SkillService;
import com.magicflare.demo.service.SkillTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping({ConstantsForApis.PREFIX+ ConstantsForApis.SKILL_TYPE})
@Slf4j
public class skillTypeController {

    @Autowired
   private SkillTypeService skillTypeService;

    @PostMapping()
    public ResponseEntity createSkill( @RequestBody @Valid SkillTypeRequest skillTypeRequest) {
log.info("");

       return new ResponseEntity<>(skillTypeService.createSkillType(skillTypeRequest), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity getSkillTypes(){

        return ResponseEntity.ok(skillTypeService.getSkillsTypeList());
    }



    @GetMapping({ConstantsForApis.SKILL_BY_ID})
    public ResponseEntity getSkillTypeById(@PathVariable("id") Integer id){

        return ResponseEntity.ok(skillTypeService.getSkillTypeById(id));
    }

    @PutMapping({ConstantsForApis.SKILL_BY_ID})
    public ResponseEntity  updateSkillTypeById(@PathVariable("id") Integer id, @Valid @RequestBody SkillTypeRequest skillTypeRequest ){
        return ResponseEntity.ok(skillTypeService.updateSkillTypeById(id,skillTypeRequest));
    }

    @DeleteMapping({ConstantsForApis.SKILL_BY_ID})
    public ResponseEntity  deleteSkillTypeByIde(@PathVariable("id") Integer id){
        return ResponseEntity.ok(skillTypeService.deleteSkillTypeById(id));
    }

}

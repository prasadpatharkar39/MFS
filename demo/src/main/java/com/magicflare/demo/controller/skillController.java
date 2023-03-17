package com.magicflare.demo.controller;

import com.magicflare.demo.constants.ConstantsForApis;
import com.magicflare.demo.dto.request.SkillRequest;
import com.magicflare.demo.service.SkillService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
//@RequestMapping({ConstantsForApis.PREFIX+ ConstantsForApis.SKILL})
@RequestMapping("/skill")
@Slf4j
public class skillController {

    @Autowired
   private SkillService skillService;

    @PostMapping("/")
//    @PostMapping()
    public ResponseEntity createSkill(@Valid @RequestBody  SkillRequest skillRequest) {

        return new ResponseEntity<>(skillService.createSkill(skillRequest),HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity getSkill(){
        return ResponseEntity.ok(skillService.getSkillsList());
    }

    @GetMapping({ConstantsForApis.SKILL_BY_ID})
    public ResponseEntity getSkillById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(skillService.getSkillById(id));
    }

    @PutMapping({ConstantsForApis.SKILL_BY_ID})
    public ResponseEntity  updateSkillById(@PathVariable("id") Integer id, @Valid @RequestBody SkillRequest skillRequest ){
        return ResponseEntity.ok(skillService.updateSkillById(id,skillRequest));
    }

    @DeleteMapping({ConstantsForApis.SKILL_BY_ID})
    public ResponseEntity  deleteSkillById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(skillService.deleteSkillById(id));
    }

}

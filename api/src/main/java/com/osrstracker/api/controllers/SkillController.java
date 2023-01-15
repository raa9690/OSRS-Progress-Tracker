package com.osrstracker.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osrstracker.api.dto.SkillDto;
import com.osrstracker.api.service.SkillService;

@RestController
@RequestMapping("/api/")
public class SkillController {
    
    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @PostMapping("skills/create")
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto skillDto){
        return new ResponseEntity<>(skillService.createSkill(skillDto), HttpStatus.CREATED);
    }

    @GetMapping("skills")

    
}

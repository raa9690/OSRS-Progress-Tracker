package com.osrstracker.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.osrstracker.api.dto.SkillDto;
import com.osrstracker.api.dto.SkillResponse;
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
    public ResponseEntity<SkillResponse> getSkills(
        @RequestParam(value="PageNo", defaultValue = "0", required = false) int pageNo,
        @RequestParam(value="PageSize", defaultValue = "10", required = false) int pageSize
    ){
        return new ResponseEntity<SkillResponse>(skillService.getSkills(pageNo,pageSize), HttpStatus.OK);
    }

    @GetMapping("skills/{id}")
    public ResponseEntity<SkillDto> getSkill(@PathVariable int id){
        return new ResponseEntity<SkillDto>(skillService.getSkill(id), HttpStatus.OK);
    }

    @PutMapping("skills/{id}/update")
    public ResponseEntity<SkillDto> updateSkill(@RequestBody SkillDto skillDto, @PathVariable int id){
        return new ResponseEntity<SkillDto>(skillService.updateSkill(skillDto, id), HttpStatus.ACCEPTED);
    }

    
}

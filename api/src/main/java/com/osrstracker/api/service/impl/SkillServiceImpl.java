package com.osrstracker.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osrstracker.api.dto.SkillDto;
import com.osrstracker.api.exceptions.SkillNotFoundException;
import com.osrstracker.api.models.Skill;
import com.osrstracker.api.repository.SkillRepository;
import com.osrstracker.api.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
    private SkillRepository skillRepo;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepo){
        this.skillRepo = skillRepo;
    }

    @Override
    public SkillDto createSkill(SkillDto skillDto) {
        Skill skill = mapToEntity(skillDto);

        Skill newSkill = skillRepo.save(skill);

        SkillDto skillResponse = mapToDto(newSkill);

        return skillResponse;
    }

    @Override
    public SkillDto[] getSkills(){
        return null;
    }

    @Override
    public SkillDto getSkill(int id){
        Skill skill = skillRepo.findById(id).orElseThrow(() -> new SkillNotFoundException("Could not find skill"));

        return mapToDto(skill);
    }

    // no delete skill
    
    @Override
    public SkillDto updateSkill(SkillDto skillDto, int id){
        Skill skill = skillRepo.findById(id).orElseThrow(() -> new SkillNotFoundException("Could not find skill"));
        
        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());

        return mapToDto(skill);
    }

    @Override
    public SkillDto[] searchSkillByName(String name){
        
        return null;
    }

    @Override
    public SkillDto mapToDto(Skill skill){
        SkillDto mappedSkillDto = new SkillDto();
        mappedSkillDto.setId(skill.getId());
        mappedSkillDto.setName(skill.getName());
        return mappedSkillDto;
    }

    @Override
    public Skill mapToEntity(SkillDto skillDto){
        Skill mappedSkill = new Skill();
        mappedSkill.setId(skillDto.getId());
        mappedSkill.setName(skillDto.getName());
        return mappedSkill;
    }
}

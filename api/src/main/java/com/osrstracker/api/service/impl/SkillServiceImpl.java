package com.osrstracker.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<SkillDto> getSkills(int pageNo, int pageSize){
        //temp functionality before reviewing how pageination works, so that I can implement ui features
        List<Skill> skills = skillRepo.findAll();

        return skills.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
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
        
        skill.setName(skillDto.getName());

        skillRepo.save(skill);

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

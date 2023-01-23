package com.osrstracker.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.osrstracker.api.dto.SkillDto;
import com.osrstracker.api.dto.SkillResponse;
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
    public SkillResponse getSkills(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Skill> skills = skillRepo.findAll(pageable);
        List<Skill> listOfSkills = skills.getContent();
        List<SkillDto> content = listOfSkills.stream().map(s -> mapToDto(s)).collect(Collectors.toList());

        SkillResponse response = new SkillResponse();
        response.setContent(content);
        response.setPageNo(skills.getNumber());
        response.setPageSize(skills.getSize());
        response.setTotalElements(skills.getTotalElements());
        response.setTotalPages(skills.getTotalPages());
        response.setLast(skills.isLast());

        return response;
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

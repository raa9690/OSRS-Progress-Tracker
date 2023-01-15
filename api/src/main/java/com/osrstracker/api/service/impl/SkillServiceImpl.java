package com.osrstracker.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osrstracker.api.dto.SkillDto;
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
        Skill skill = new Skill();
        skill.setName(skillDto.getName());

        Skill newSkill = skillRepo.save(skill);

        SkillDto skillResponse = new SkillDto();
        skillResponse.setId(newSkill.getId());
        skillResponse.setName(newSkill.getName());

        return skillResponse;
    }
}

package com.osrstracker.api.service;

import com.osrstracker.api.dto.SkillDto;
import com.osrstracker.api.models.Skill;

public interface SkillService {
    SkillDto createSkill(SkillDto skillDto);
    SkillDto[] getSkills();
    SkillDto getSkill(int id);
    // no delete skill
    SkillDto updateSkill(SkillDto skillDto, int id);
    SkillDto[] searchSkillByName(String name);
    SkillDto mapToDto(Skill skill);
    Skill mapToEntity(SkillDto skillDto);
}

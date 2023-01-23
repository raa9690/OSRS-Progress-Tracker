package com.osrstracker.api.service;

import java.util.List;

import com.osrstracker.api.dto.SkillDto;
import com.osrstracker.api.dto.SkillResponse;
import com.osrstracker.api.models.Skill;

public interface SkillService {
    SkillDto createSkill(SkillDto skillDto);
    SkillResponse getSkills(int pageNo, int pageSize);
    SkillDto getSkill(int id);
    // no delete skill
    SkillDto updateSkill(SkillDto skillDto, int id);
    SkillDto[] searchSkillByName(String name);
    SkillDto mapToDto(Skill skill);
    Skill mapToEntity(SkillDto skillDto);
}

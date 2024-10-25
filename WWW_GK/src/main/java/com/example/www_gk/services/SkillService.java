package com.example.www_gk.services;

import com.example.www_gk.models.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getAllSkill();

    boolean insert(Skill skill);
}

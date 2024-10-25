package com.example.demo1.services;

import com.example.demo1.models.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getAllSkill();

    boolean insert(Skill skill);
}

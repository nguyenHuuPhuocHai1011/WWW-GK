package com.example.demo2.dao;

import com.example.demo2.models.Skill;

import java.util.List;

public interface SkillDao {
    List<Skill> getAllSkill();

    boolean insert(Skill skill);
}

package com.example.www_gk.services.impl;

import com.example.www_gk.models.Skill;
import com.example.www_gk.repositories.SkillRepository;
import com.example.www_gk.services.SkillService;

import java.util.List;

public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;

    public SkillServiceImpl() {
        repository = new SkillRepository();
    }


    @Override
    public List<Skill> getAllSkill() {
        return repository.getAll(Skill.class);
    }

    @Override
    public boolean insert(Skill skill) {
        return repository.insert(skill);
    }
}

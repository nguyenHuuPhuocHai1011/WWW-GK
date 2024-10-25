package com.example.demo.services.impl;

import com.example.demo.models.Skill;
import com.example.demo.repositories.SkillRepository;
import com.example.demo.services.SkillService;

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
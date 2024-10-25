package com.example.demo2.daoimpl;

import com.example.demo2.dao.SkillDao;
import com.example.demo2.models.Skill;
import com.example.demo2.repositories.SkillRepository;

import java.util.List;

public class SkillDaoImpl implements SkillDao {
    private final SkillRepository repository;

    public SkillDaoImpl() {
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

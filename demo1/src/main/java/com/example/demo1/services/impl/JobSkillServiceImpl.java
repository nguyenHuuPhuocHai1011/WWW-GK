package com.example.demo1.services.impl;

import com.example.demo1.models.JobSkill;
import com.example.demo1.repositories.JobSkillRepository;
import com.example.demo1.services.JobSkillService;

import java.util.List;

public class JobSkillServiceImpl implements JobSkillService {
    private final JobSkillRepository repository;

    public JobSkillServiceImpl() {
        repository = new JobSkillRepository();
    }

    @Override
    public List<JobSkill> getAllJobSkill() {
        return null;
    }

    @Override
    public boolean insert(JobSkill jobSkill) {
        return false;
    }
}

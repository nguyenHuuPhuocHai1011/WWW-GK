package com.example.demo.services.impl;

import com.example.demo.models.JobSkill;
import com.example.demo.repositories.JobSkillRepository;
import com.example.demo.services.JobSkillService;

import java.util.List;

public class JobSkillServiceImpl implements JobSkillService {
    private final JobSkillRepository repository;

    public JobSkillServiceImpl() {
        repository = new JobSkillRepository();
    }


    @Override
    public List<JobSkill> getAllJobSkill() {
        return repository.getAll(JobSkill.class);
    }

    @Override
    public boolean insert(JobSkill jobSkill) {
        return repository.insert(jobSkill);
    }
}

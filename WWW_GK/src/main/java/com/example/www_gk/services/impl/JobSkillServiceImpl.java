package com.example.www_gk.services.impl;

import com.example.www_gk.models.JobSkill;
import com.example.www_gk.repositories.JobSkillRepository;
import com.example.www_gk.services.JobSkillService;

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

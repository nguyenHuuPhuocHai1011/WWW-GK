package com.example.demo2.daoimpl;

import com.example.demo2.dao.JobSkillDao;
import com.example.demo2.models.JobSkill;
import com.example.demo2.repositories.JobSkillRepository;

import java.util.List;

public class JobSkillDaoImpl implements JobSkillDao {
    private final JobSkillRepository repository;

    public JobSkillDaoImpl() {
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

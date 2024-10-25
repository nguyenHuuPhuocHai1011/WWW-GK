package com.example.demo1.services;

import com.example.demo1.models.JobSkill;

import java.util.List;

public interface JobSkillService {
    List<JobSkill> getAllJobSkill();

    boolean insert(JobSkill jobSkill);
}

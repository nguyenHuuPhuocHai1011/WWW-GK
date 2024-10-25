package com.example.demo.services;

import com.example.demo.models.JobSkill;

import java.util.List;

public interface JobSkillService {
    List<JobSkill> getAllJobSkill();

    boolean insert(JobSkill jobSkill);
}

package com.example.www_gk.services;

import com.example.www_gk.models.JobSkill;

import java.util.List;

public interface JobSkillService {
    List<JobSkill> getAllJobSkill();

    boolean insert(JobSkill jobSkill);
}

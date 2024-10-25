package com.example.demo2.dao;

import com.example.demo2.models.JobSkill;

import java.util.List;

public interface JobSkillDao {
    List<JobSkill> getAllJobSkill();

    boolean insert(JobSkill jobSkill);
}

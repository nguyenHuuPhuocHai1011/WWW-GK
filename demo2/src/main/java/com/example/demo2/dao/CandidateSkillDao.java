package com.example.demo2.dao;

import com.example.demo2.models.CandidateSkill;

import java.util.List;

public interface CandidateSkillDao {
    List<CandidateSkill> getAllCandidateSkill();

    boolean insert(CandidateSkill candidateSkill);
}

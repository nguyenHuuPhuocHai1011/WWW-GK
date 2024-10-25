package com.example.demo1.services;

import com.example.demo1.models.CandidateSkill;

import java.util.List;

public interface CandidateSkillService {
    List<CandidateSkill> getAllCandidateSkill();

    boolean insert(CandidateSkill candidateSkill);
}

package com.example.demo.services;

import com.example.demo.models.CandidateSkill;

import java.util.List;

public interface CandidateSkillService {
    List<CandidateSkill> getAllCandidateSkill();

    boolean insert(CandidateSkill candidateSkill);
}

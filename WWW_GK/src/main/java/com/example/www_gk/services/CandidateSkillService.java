package com.example.www_gk.services;

import com.example.www_gk.models.CandidateSkill;

import java.util.List;

public interface CandidateSkillService {
    List<CandidateSkill> getAllCandidateSkill();

    boolean insert (CandidateSkill candidateSkill);
}

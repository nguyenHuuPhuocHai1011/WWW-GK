package com.example.www_gk.services.impl;

import com.example.www_gk.models.CandidateSkill;
import com.example.www_gk.repositories.CandidateSkillRepository;
import com.example.www_gk.services.CandidateSkillService;

import java.util.List;

public class CandidateSkillServiceImpl implements CandidateSkillService {
    private final CandidateSkillRepository repository;

    public CandidateSkillServiceImpl() {
        repository = new CandidateSkillRepository();
    }

    @Override
    public List<CandidateSkill> getAllCandidateSkill() {
        return repository.getAll(CandidateSkill.class);
    }

    @Override
    public boolean insert(CandidateSkill candidateSkill) {
        return repository.insert(candidateSkill);
    }
}

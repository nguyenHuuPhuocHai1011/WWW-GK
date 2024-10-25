package com.example.demo.services.impl;

import com.example.demo.models.CandidateSkill;
import com.example.demo.repositories.CandidateSkillRepository;
import com.example.demo.services.CandidateSkillService;

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
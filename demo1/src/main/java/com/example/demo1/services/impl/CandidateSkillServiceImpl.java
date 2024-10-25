package com.example.demo1.services.impl;

import com.example.demo1.models.CandidateSkill;
import com.example.demo1.repositories.CandidateSkillRepository;
import com.example.demo1.services.CandidateSkillService;

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

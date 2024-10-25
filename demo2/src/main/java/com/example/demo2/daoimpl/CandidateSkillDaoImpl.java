package com.example.demo2.daoimpl;

import com.example.demo2.dao.CandidateSkillDao;
import com.example.demo2.models.CandidateSkill;
import com.example.demo2.repositories.CandidateSkillRepository;

import java.util.List;

public class CandidateSkillDaoImpl implements CandidateSkillDao {
    private final CandidateSkillRepository repository;

    public CandidateSkillDaoImpl() {
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

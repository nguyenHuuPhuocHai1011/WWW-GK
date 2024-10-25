package com.example.demo2.daoimpl;

import com.example.demo2.dao.CandidateDao;
import com.example.demo2.models.Candidate;
import com.example.demo2.repositories.CandidateRepository;

import java.util.List;
import java.util.Optional;

public class CandidateDaoImpl implements CandidateDao {
    private final CandidateRepository repository;

    public CandidateDaoImpl() {
        repository = new CandidateRepository();
    }

    @Override
    public List<Candidate> getAllCandidate() {
        return repository.getAll(Candidate.class);
    }

    @Override
    public Candidate getCandidateDetail(long id) throws Exception {
        Optional<Candidate> candidate = repository.get(Candidate.class, id);
        if (candidate.isEmpty())
            throw new Exception("Not found");
        return candidate.get();
    }

    @Override
    public boolean insert(Candidate candidate) {
        return repository.insert(candidate);
    }

    @Override
    public List<Candidate> findCandidateBySkillLevel(int skillLevel) {
        return repository.findCandidateByLevel(skillLevel);
    }

    @Override
    public List<Candidate> findCandidateHasEmail() {
        return repository.findCandidateHasEmail();
    }
}

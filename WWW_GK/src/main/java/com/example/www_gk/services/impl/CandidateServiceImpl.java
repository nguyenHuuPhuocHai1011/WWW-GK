package com.example.www_gk.services.impl;

import com.example.www_gk.models.Candidate;
import com.example.www_gk.repositories.CandidateRepository;
import com.example.www_gk.services.CandidateService;

import java.util.List;
import java.util.Optional;

public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository repository;

    public CandidateServiceImpl() {
        repository = new CandidateRepository();
    }

    @Override
    public List<Candidate> getAllCandidate() {
        return repository.getAll(Candidate.class);
    }

    @Override
    public Candidate getCandidateDetail(long id) throws Exception{
        Optional<Candidate> candidate = repository.get(Candidate.class, id);
        if(candidate.isEmpty())
            throw new Exception("Candidate not found");
        return candidate.get();
    }

    @Override
    public boolean insert(Candidate candidate) {
        return repository.insert(candidate);
    }

    @Override
    public List<Candidate> findCandidateBySkillLevel(int skillLevel){
        return repository.findCandidateByLevel(skillLevel);
    }

    @Override
    public List<Candidate> findCandidateHasEmail(){
        return repository.findCandidateHasEmail();
    }
}

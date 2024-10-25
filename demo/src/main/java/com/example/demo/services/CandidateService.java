package com.example.demo.services;

import com.example.demo.models.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getAllCandidate();
    Candidate getCandidateDetail(Long id) throws Exception;
    boolean insert(Candidate candidate);
    List<Candidate> findCandidateBySkillLevel(int skillLevel);
    List<Candidate> findCandidateHasEmail();
}

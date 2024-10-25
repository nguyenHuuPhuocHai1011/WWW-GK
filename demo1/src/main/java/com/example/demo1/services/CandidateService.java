package com.example.demo1.services;

import com.example.demo1.models.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getAllCandidate();
    Candidate getCandidateDetail(long id) throws Exception;
    boolean insert(Candidate candidate);
    List<Candidate> findCandidateBySkillLevel(int skillLevel);
    List<Candidate> findCandidateHasEmail();
}

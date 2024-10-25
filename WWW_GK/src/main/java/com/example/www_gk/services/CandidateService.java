package com.example.www_gk.services;

import com.example.www_gk.models.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getAllCandidate();
    Candidate getCandidateDetail(long id) throws Exception;
    boolean insert(Candidate candidate);
    List<Candidate> findCandidateBySkillLevel(int skillLevel);
    List<Candidate> findCandidateHasEmail();
}

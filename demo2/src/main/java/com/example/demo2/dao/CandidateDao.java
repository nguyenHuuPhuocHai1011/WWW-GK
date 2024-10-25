package com.example.demo2.dao;

import com.example.demo2.models.Candidate;

import java.util.List;

public interface CandidateDao {
    List<Candidate> getAllCandidate();
    Candidate getCandidateDetail(long id) throws Exception;
    boolean insert(Candidate candidate);
    List<Candidate> findCandidateBySkillLevel(int skillLevel);
    List<Candidate> findCandidateHasEmail();
}

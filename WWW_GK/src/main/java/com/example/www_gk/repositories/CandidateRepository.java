package com.example.www_gk.repositories;

import com.example.www_gk.enums.SkillLevel;
import com.example.www_gk.models.Candidate;
import com.example.www_gk.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepository extends CRUDRepository<Candidate>{
    public CandidateRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }

    public List<Candidate> findCandidateByLevel(int level) {
        List<Candidate> candidates = new ArrayList<>();
        try{
            transaction.begin();
            Query query = entityManager.createNamedQuery("candidate.findCandidateBySkillLevel")
                    .setParameter("skillLevel", SkillLevel.values()[level]);
            candidates = query.getResultList();
            transaction.commit();

        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return candidates;
    }

    public List<Candidate> findCandidateHasEmail() {
        List<Candidate> candidates = new ArrayList<>();
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("candidate.findCandidateHasEmail");
            candidates = query.getResultList();
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return candidates;
    }
}

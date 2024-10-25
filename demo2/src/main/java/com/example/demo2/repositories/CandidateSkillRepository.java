package com.example.demo2.repositories;

import com.example.demo2.connect.ConnectDB;
import com.example.demo2.models.CandidateSkill;
import jakarta.persistence.EntityManager;

public class CandidateSkillRepository extends CRUDRepository<CandidateSkill> {
    public CandidateSkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

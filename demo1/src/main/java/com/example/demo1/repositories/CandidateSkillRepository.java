package com.example.demo1.repositories;

import com.example.demo1.models.CandidateSkill;
import com.example.demo1.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class CandidateSkillRepository extends CRUDRepository<CandidateSkill> {
    public CandidateSkillRepository() {
        EntityManager em = ConnectDB.getInstance().getEntityManager();
    }
}

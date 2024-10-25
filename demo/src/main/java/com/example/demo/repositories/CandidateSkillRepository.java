package com.example.demo.repositories;

import com.example.demo.models.CandidateSkill;
import com.example.demo.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class CandidateSkillRepository extends CRUDRepository<CandidateSkill> {
    public CandidateSkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

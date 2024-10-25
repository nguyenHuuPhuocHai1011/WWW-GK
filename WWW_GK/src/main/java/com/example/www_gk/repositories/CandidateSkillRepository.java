package com.example.www_gk.repositories;

import com.example.www_gk.models.CandidateSkill;
import com.example.www_gk.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class CandidateSkillRepository extends CRUDRepository<CandidateSkill> {
    public CandidateSkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

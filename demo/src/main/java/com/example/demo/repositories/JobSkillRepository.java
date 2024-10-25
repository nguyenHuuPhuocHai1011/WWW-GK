package com.example.demo.repositories;

import com.example.demo.models.JobSkill;
import com.example.demo.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class JobSkillRepository extends CRUDRepository<JobSkill> {
    public JobSkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

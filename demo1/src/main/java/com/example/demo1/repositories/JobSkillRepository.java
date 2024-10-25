package com.example.demo1.repositories;

import com.example.demo1.models.JobSkill;
import com.example.demo1.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class JobSkillRepository extends CRUDRepository<JobSkill> {
    public JobSkillRepository() {
        EntityManager em = ConnectDB.getInstance().getEntityManager();
    }
}

package com.example.demo2.repositories;

import com.example.demo2.connect.ConnectDB;
import com.example.demo2.models.JobSkill;
import jakarta.persistence.EntityManager;

public class JobSkillRepository extends CRUDRepository<JobSkill>{
    public JobSkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

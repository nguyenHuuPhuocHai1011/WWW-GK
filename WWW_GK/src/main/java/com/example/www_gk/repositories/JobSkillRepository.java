package com.example.www_gk.repositories;

import com.example.www_gk.models.JobSkill;
import com.example.www_gk.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class JobSkillRepository extends CRUDRepository<JobSkill>{
    public JobSkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

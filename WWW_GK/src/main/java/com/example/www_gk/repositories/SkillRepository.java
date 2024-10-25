package com.example.www_gk.repositories;

import com.example.www_gk.models.Skill;
import com.example.www_gk.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class SkillRepository extends CRUDRepository<Skill> {
    public SkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

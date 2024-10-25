package com.example.demo1.repositories;

import com.example.demo1.models.Skill;
import com.example.demo1.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class SkillRepository extends CRUDRepository<Skill> {
    public SkillRepository() {
        EntityManager em = ConnectDB.getInstance().getEntityManager();
    }
}

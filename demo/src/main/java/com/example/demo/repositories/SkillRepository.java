package com.example.demo.repositories;

import com.example.demo.models.Skill;
import com.example.demo.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class SkillRepository extends CRUDRepository<Skill> {
    public SkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

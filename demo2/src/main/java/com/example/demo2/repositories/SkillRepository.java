package com.example.demo2.repositories;

import com.example.demo2.connect.ConnectDB;
import com.example.demo2.models.Skill;
import jakarta.persistence.EntityManager;

public class SkillRepository extends CRUDRepository<Skill>{
    public SkillRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

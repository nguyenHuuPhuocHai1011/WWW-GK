package com.example.demo.repositories;

import com.example.demo.models.Job;
import com.example.demo.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class JobRepository extends CRUDRepository<Job> {
    public JobRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

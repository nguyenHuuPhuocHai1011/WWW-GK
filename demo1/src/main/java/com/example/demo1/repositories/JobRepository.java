package com.example.demo1.repositories;

import com.example.demo1.models.Job;
import com.example.demo1.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class JobRepository extends CRUDRepository<Job> {
    public JobRepository() {
        EntityManager em = ConnectDB.getInstance().getEntityManager();
    }
}

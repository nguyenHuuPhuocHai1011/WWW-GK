package com.example.demo2.repositories;

import com.example.demo2.connect.ConnectDB;
import com.example.demo2.models.Job;
import jakarta.persistence.EntityManager;

public class JobRepository extends CRUDRepository<Job> {
    public JobRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

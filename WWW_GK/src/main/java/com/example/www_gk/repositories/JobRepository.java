package com.example.www_gk.repositories;

import com.example.www_gk.models.Job;
import com.example.www_gk.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;

public class JobRepository extends CRUDRepository<Job> {
    public JobRepository() {
        EntityManager manager = ConnectDB.getInstance().getEntityManager();
    }
}

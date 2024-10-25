package com.example.demo2.daoimpl;

import com.example.demo2.dao.JobDao;
import com.example.demo2.models.Job;
import com.example.demo2.repositories.JobRepository;

import java.util.List;

public class JobDaoImpl implements JobDao {
    private final JobRepository repository;

    public JobDaoImpl() {
        repository = new JobRepository();
    }

    @Override
    public List<Job> getAllJob() {
        return repository.getAll(Job.class);
    }

    @Override
    public boolean insert(Job job) {
        return repository.insert(job);
    }
}

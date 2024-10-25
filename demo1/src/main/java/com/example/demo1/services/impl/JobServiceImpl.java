package com.example.demo1.services.impl;

import com.example.demo1.models.Job;
import com.example.demo1.repositories.JobRepository;
import com.example.demo1.services.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {
    private final JobRepository repository;

    public JobServiceImpl() {
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

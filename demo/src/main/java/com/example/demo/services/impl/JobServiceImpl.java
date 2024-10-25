package com.example.demo.services.impl;

import com.example.demo.models.Job;
import com.example.demo.repositories.JobRepository;
import com.example.demo.services.JobService;

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
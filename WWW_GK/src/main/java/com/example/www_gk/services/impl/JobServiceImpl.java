package com.example.www_gk.services.impl;

import com.example.www_gk.models.Job;
import com.example.www_gk.repositories.JobRepository;
import com.example.www_gk.services.JobService;

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

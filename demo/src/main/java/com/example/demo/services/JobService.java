package com.example.demo.services;

import com.example.demo.models.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJob();

    boolean insert(Job job);
}

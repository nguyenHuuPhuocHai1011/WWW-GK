package com.example.demo1.services;

import com.example.demo1.models.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJob();

    boolean insert(Job job);
}

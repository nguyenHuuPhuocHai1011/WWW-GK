package com.example.www_gk.services;

import com.example.www_gk.models.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJob();

    boolean insert(Job job);
}

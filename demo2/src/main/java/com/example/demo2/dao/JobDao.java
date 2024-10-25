package com.example.demo2.dao;

import com.example.demo2.models.Job;

import java.util.List;

public interface JobDao {
    List<Job> getAllJob();

    boolean insert(Job job);
}

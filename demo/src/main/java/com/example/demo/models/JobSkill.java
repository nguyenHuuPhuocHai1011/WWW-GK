package com.example.demo.models;

import com.example.demo.enums.SkillLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "job_skill")
public class JobSkill {

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Enumerated(EnumType.STRING)
    private SkillLevel requiredSkillLevel;

    public JobSkill(Skill skill, Job job, SkillLevel requiredSkillLevel) {
        this.skill = skill;
        this.job = job;
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public JobSkill() {
    }

    public Job getJob() {
        return job;
    }

    public Skill getSkill() {
        return skill;
    }

    public SkillLevel getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setRequiredSkillLevel(SkillLevel requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ", skill=" + skill +
                ", requiredSkillLevel=" + requiredSkillLevel +
                '}';
    }
}
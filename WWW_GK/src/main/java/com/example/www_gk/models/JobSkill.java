package com.example.www_gk.models;

import com.example.www_gk.enums.SkillLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "jobSkill")
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

    @Override
    public String toString() {
        return "JobSkill{" +
                "skill=" + skill +
                ", job=" + job +
                ", requiredSkillLevel=" + requiredSkillLevel +
                '}';
    }

    public Skill getSkill() {
        return skill;
    }

    public Job getJob() {
        return job;
    }

    public SkillLevel getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public void setRequiredSkillLevel(SkillLevel requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public JobSkill(Skill skill, Job job, SkillLevel requieredSkillLevel) {
        this.skill = skill;
        this.job = job;
        this.requiredSkillLevel = requieredSkillLevel;}

    public JobSkill() {
    }
}

package com.example.www_gk.models;

import com.example.www_gk.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidateSkill")
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    public CandidateSkill(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public CandidateSkill() {

    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public CandidateSkill(Candidate candidate) {
        this.candidate = candidate;
    }

    public CandidateSkill(Candidate candidate, Skill skill, SkillLevel skillLevel) {
        this.candidate = candidate;
        this.skill = skill;
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "candidate=" + candidate +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                '}';
    }
}

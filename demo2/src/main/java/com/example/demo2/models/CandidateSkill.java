package com.example.demo2.models;


import com.example.demo2.enums.SkillLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "candidate_skill")
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

    public CandidateSkill(Candidate candidate, Skill skill, SkillLevel skillLevel) {
        this.candidate = candidate;
        this.skill = skill;
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

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "candidate=" + candidate +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                '}';
    }
}

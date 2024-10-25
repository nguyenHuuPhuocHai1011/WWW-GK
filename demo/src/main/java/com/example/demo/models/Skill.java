package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;
    @Column(name = "skill_name")
    private String skillName;
    private String description;
    private String field;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<CandidateSkill> candidateSkills;

    public Skill(String skillName, String description, String field, List<CandidateSkill> candidateSkills) {
        this.skillName = skillName;
        this.description = description;
        this.field = field;
        this.candidateSkills = candidateSkills;
    }

    public Skill(String skillName, String description, String field) {
        this.skillName = skillName;
        this.description = description;
        this.field = field;
    }

    public Skill() {
    }

    public List<CandidateSkill> getCandidateSkills() {
        return candidateSkills;
    }

    public String getField() {
        return field;
    }

    public String getDescription() {
        return description;
    }

    public String getSkillName() {
        return skillName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                ", description='" + description + '\'' +
                ", field='" + field + '\'' +
                ", candidateSkills=" + candidateSkills +
                '}';
    }
}
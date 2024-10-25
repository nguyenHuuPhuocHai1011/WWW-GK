package com.example.www_gk.data;

import com.example.www_gk.enums.SkillLevel;
import com.example.www_gk.models.*;
import com.example.www_gk.repositories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddData {
    public static void main(String[] args) {
        //Add candidate
        Candidate candidate1 = new Candidate("Huynh", "Tam", "Nhu", "12 Nguyen Van Bao", "tamnhu@gmail.com", "0348333253", LocalDate.of(2024, 1, 1), null);
        CandidateRepository repository = new CandidateRepository();
        repository.insert(candidate1);
        System.out.println(candidate1);

        //Add skill
        Skill skill1 = new Skill("Java", "Knowledge of Java programming language.", "IT", null);
        Skill skill2 = new Skill("React ", "Knowledge of Java programming language.", "Front End", null);
        Skill skill3 = new Skill("Nodejs ", "Knowledge of Java programming language.", "Back end", null);
        SkillRepository skillRepository = new SkillRepository();
        skillRepository.insert(skill1);
        skillRepository.insert(skill2);
        skillRepository.insert(skill3);

        //Add job
        Job job1 = new Job("Intern Front End", "Assisting in the development of front-end applications.");
        Job job2 = new Job("Intern Back End", "Experience with Spring Boot framework");
        Job job3 = new Job("Intern QA", "Assisting in the testing and quality assurance of applications.");
        JobRepository jobRepository = new JobRepository();
        jobRepository.insert(job1);
        jobRepository.insert(job2);
        jobRepository.insert(job3);

        //Add CandidateSkill
        CandidateSkill candidateSkill1 = new CandidateSkill(candidate1,skill1, SkillLevel.BEGINNER);
        CandidateSkillRepository candidateSkillRepository = new CandidateSkillRepository();
        candidateSkillRepository.insert(candidateSkill1);
        System.out.println(candidateSkill1);

        //Add JobSkill
        JobSkill jobSkill1 = new JobSkill(skill1, job1, SkillLevel.BEGINNER);
        JobSkill jobSkill2 = new JobSkill(skill2, job2, SkillLevel.ADVANCED);
        JobSkill jobSkill3 = new JobSkill(skill3, job3, SkillLevel.EXPERT);
        JobSkillRepository jobSkillRepository = new JobSkillRepository();
        jobSkillRepository.insert(jobSkill1);
        jobSkillRepository.insert(jobSkill2);
        jobSkillRepository.insert(jobSkill3);
    }
}

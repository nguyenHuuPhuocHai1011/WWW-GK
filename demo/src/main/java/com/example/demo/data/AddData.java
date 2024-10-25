package com.example.demo.data;

import com.example.demo.enums.SkillLevel;
import com.example.demo.models.*;
import com.example.demo.repositories.*;

import java.time.LocalDate;

public class AddData {
    public static void main(String[] args) {
        //add candidate
        Candidate candidate1 = new Candidate("Huynh", "Tam", "Nhu", "tamnhu@gmail.com", "0348333253", "12 Nguyen Van Bao", LocalDate.of(2024, 1, 1), null);
        CandidateRepository repository = new CandidateRepository();
        repository.insert(candidate1);
        System.out.println(candidate1);

        //add skill
        Skill skill1 = new Skill("Java", "Java programming language", "IT", null);
        Skill skill2 = new Skill("Python", "Python programming language", "IT", null);
        Skill skill3 = new Skill("C++", "C++ programming language", "IT", null);
        SkillRepository skillRepository = new SkillRepository();
        skillRepository.insert(skill1);
        skillRepository.insert(skill2);
        skillRepository.insert(skill3);

        // add job
        Job job1 = new Job("Intern Front End", "Assisting in the development of front-end applications.");
        Job job2 = new Job("Intern Back End", "Assisting in the development of back-end applications.");
        Job job3 = new Job("Intern Full Stack", "Assisting in the development of full-stack applications.");
        JobRepository jobRepository = new JobRepository();
        jobRepository.insert(job1);
        jobRepository.insert(job2);
        jobRepository.insert(job3);

        //add candidate skill
        CandidateSkill candidateSkill1 = new CandidateSkill(candidate1, skill1, SkillLevel.BEGINNER);
        CandidateSkillRepository candidateSkillRepository = new CandidateSkillRepository();
        candidateSkillRepository.insert(candidateSkill1);
        System.out.println(candidateSkill1);

        //add job skill
        JobSkill jobSkill1 = new JobSkill(skill1, job1, SkillLevel.BEGINNER);
        JobSkill jobSkill2 = new JobSkill(skill2, job2, SkillLevel.BEGINNER);
        JobSkill jobSkill3 = new JobSkill(skill3, job3, SkillLevel.BEGINNER);
        JobSkillRepository jobSkillRepository = new JobSkillRepository();
        jobSkillRepository.insert(jobSkill1);
        jobSkillRepository.insert(jobSkill2);
        jobSkillRepository.insert(jobSkill3);
        System.out.println(jobSkill1);
        System.out.println(jobSkill2);
        System.out.println(jobSkill3);

    }
}

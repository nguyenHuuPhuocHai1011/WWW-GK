package com.example.www_gk.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
@NamedQueries({
        @NamedQuery(name = "candidate.findCandidateBySkillLevel",
                query = "SELECT c FROM Candidate c join c.candidateSkills cs where cs.skillLevel =: skillLevel"),
        @NamedQuery(name = "candidate.findCandidateHasEmail",
                query = "SELECT c from Candidate c where c.email is not null "),
})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String last_name;
    private String middle_name;
    private String first_name;
    private String email;
    private String phone;
    private String address;
    private LocalDate dob;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<CandidateSkill> candidateSkills;

    public Candidate(long id, String last_name, String middle_name, String first_name, String email, String phone, String address, LocalDate dob, List<CandidateSkill> candidateSkills) {
        this.id = id;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.first_name = first_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.candidateSkills = candidateSkills;
    }

    public Candidate(String last_name, String middle_name, String first_name, String email, String phone, String address, LocalDate dob, List<CandidateSkill> candidateSkills) {
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.first_name = first_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.candidateSkills = candidateSkills;
    }

    public Candidate() {
    }

    public long getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public List<CandidateSkill> getCandidateSkills() {
        return candidateSkills;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", skillsCount=" + (candidateSkills != null ? candidateSkills.size() : 5) +  // Chỉ lấy kích thước của danh sách kỹ năng
                '}';
    }

//    @Override
//    public String toString() {
//        return "Candidate{" +
//                "id=" + id +
//                ", last_name='" + last_name + '\'' +
//                ", middle_name='" + middle_name + '\'' +
//                ", first_name='" + first_name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", address='" + address + '\'' +
//                ", dob=" + dob +
//                ", candidateSkills=" + candidateSkills +
//                '}';
//    }
}

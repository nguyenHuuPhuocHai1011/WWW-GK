package com.example.demo2;

import com.example.demo2.dao.CandidateDao;
import com.example.demo2.dao.JobDao;
import com.example.demo2.dao.SkillDao;
import com.example.demo2.daoimpl.CandidateDaoImpl;
import com.example.demo2.daoimpl.JobDaoImpl;
import com.example.demo2.daoimpl.SkillDaoImpl;
import com.example.demo2.enums.SkillLevel;
import com.example.demo2.models.Candidate;
import com.example.demo2.models.CandidateSkill;
import com.example.demo2.models.Job;
import com.example.demo2.models.Skill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PageServlet", value = "/page")
public class PageServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            String action = req.getParameter("action");
            if (action == null) {
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action) {
                case "home": {
                    PrintWriter out = resp.getWriter();
                    out.println("<html><body>");
                    out.println("<h1> Home </h1>");
                    out.println("</body></html>");
                }
                case "candidate":
                    handleActionCandidate(req, resp);
                    break;
                case "detail-candidate":
                    handleActionCandidateDetail(req, resp);
                    break;
                case "job":
                    handleActionJob(req, resp);
                    break;
                case "skill":
                    handleActionSkill(req, resp);
                    break;
                case "report1":
                    handleGetReport1(req, resp);
                    break;
                case "report2":
                    handleGetReport2(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleGetReport2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateDao service = new CandidateDaoImpl();
        List<Candidate> candidates = service.findCandidateHasEmail();
        req.setAttribute("candidates", candidates);
        String path = "/views/report2.jsp";
        forwardToPage(path, req, resp);
    }

    private void forwardToPage(String path, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(path).include(req, resp);
    }

    private void handleGetReport1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/views/report1.jsp";
        forwardToPage(path, req, resp);
    }

    private void handleActionSkill(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SkillDao service = new SkillDaoImpl();
        List<Skill> skills = service.getAllSkill();
        req.setAttribute("skills", skills);
        String path = "/views/skill.jsp";
        forwardToPage(path, req, resp);
    }

    private void handleActionJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobDao service = new JobDaoImpl();
        List<Job> jobs = service.getAllJob();
        req.setAttribute("jobs", jobs);
        String path = "/views/job.jsp";
        forwardToPage(path, req, resp);
    }

    private void handleActionCandidateDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long can_id = Long.parseLong(req.getParameter("id"));
        CandidateDao service = new CandidateDaoImpl();
        Candidate candidate = service.getCandidateDetail(can_id);
        System.out.println(candidate);
        req.setAttribute("candidate", candidate);
        String path = "/views/candidate_detail.jsp";
        forwardToPage(path, req, resp);
    }

    private void handleActionCandidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateDao service = new CandidateDaoImpl();
        List<Candidate> candidates = service.getAllCandidate();
        req.setAttribute("candidates", candidates);
        String path = "/views/candidate.jsp";
        forwardToPage(path, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if(action == null){
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action){
                case "report1":
                    handleReportFillerCandidateByLevel(req,resp);
                    break;
                case "insertCandidate":
                    handleInsertCandidate(req,resp);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleInsertCandidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));

        //Lấy skillLevel từ form và ánh xạ nó sang SkillLevel enum
        String skillLevelParam = req.getParameter("skillLevel");
        int skillLevelInt = Integer.parseInt(skillLevelParam); // Chuyển đổi chuỗi sang số nguyên

        SkillLevel skillLevel = null;
        switch (skillLevelInt){
            case 1:
                skillLevel = SkillLevel.BEGINNER;
                break;
            case 2:
                skillLevel = SkillLevel.INTERMEDIATE;
                break;
            case 3:
                skillLevel = SkillLevel.ADVANCED;
                break;
            case 4:
                skillLevel = SkillLevel.EXPERT;
                break;
            case 5:
                skillLevel = SkillLevel.MASTER;
                break;
            default:
                throw new IllegalArgumentException("Invalid skill level: " + skillLevelInt);
        }

        // Tạo đối tượng Candidate
        Candidate candidate = new Candidate();
        candidate.setFirst_name(firstName);
        candidate.setMiddle_name(middleName);
        candidate.setLast_name(lastName);
        candidate.setPhone(phone);
        candidate.setEmail(email);
        candidate.setAddress(address);
        candidate.setDob(dob);

        // Tạo danh sách kỹ năng
        List<CandidateSkill> candidateSkills = new ArrayList<>();
        Skill skill = new Skill();
        skill.setId(1L);

        // Tạo CandidateSkill và gán giá trị cho nó
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(candidate);
        candidateSkill.setSkill(skill);
        candidateSkill.setSkillLevel(skillLevel);

        // Thêm CandidateSkill vào danh sách kỹ năng
        candidateSkills.add(candidateSkill);
        candidate.setCandidateSkills(candidateSkills);

        // Gọi service để thêm candidate vào CSDL
        CandidateDao service = new CandidateDaoImpl();
        service.insert(candidate);

        // Chuyển hướng về trang danh sách ứng viên sau khi thêm thành công
        resp.sendRedirect("/page?action=candidate");
    }

    private void handleReportFillerCandidateByLevel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateDao service = new CandidateDaoImpl();
        int skillLevel = Integer.parseInt(req.getParameter("skillLevel"));
        System.out.println(skillLevel);
        List<Candidate> candidatesByLevel = service.findCandidateBySkillLevel(skillLevel);
        req.setAttribute("candidates", candidatesByLevel);
        String page = "/views/report1.jsp";
        System.out.println(candidatesByLevel);
        forwardToPage(page, req, resp);
    }
}
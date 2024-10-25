package com.example.demo;

import com.example.demo.enums.SkillLevel;
import com.example.demo.models.Candidate;
import com.example.demo.models.CandidateSkill;
import com.example.demo.models.Job;
import com.example.demo.models.Skill;
import com.example.demo.services.CandidateService;
import com.example.demo.services.JobService;
import com.example.demo.services.SkillService;
import com.example.demo.services.impl.CandidateServiceImpl;
import com.example.demo.services.impl.JobServiceImpl;
import com.example.demo.services.impl.SkillServiceImpl;
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
            if(action == null) {
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action){
                case "home":{
                    PrintWriter out = resp.getWriter();
                    out.println("<html><body>");
                    out.println("<h1>Home</h1>");
                    out.println("</body></html>");
                    break;
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
        CandidateService service = new CandidateServiceImpl();
        List<Candidate> candidates = service.findCandidateHasEmail();
        req.setAttribute("candidates", candidates);
        String page = "/report/report2.jsp";
        forwardToPage(page, req, resp);
    }

    private void forwardToPage(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(page).include(req, resp);
    }

    private void handleGetReport1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "/report/report1.jsp";
        forwardToPage(page, req, resp);
    }

    private void handleActionSkill(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SkillService service = new SkillServiceImpl();
        List<Skill> skills = service.getAllSkill();
        req.setAttribute("skills", skills);
        String page = "/skill/skill.jsp";
        forwardToPage(page, req, resp);
    }

    private void handleActionJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobService service = new JobServiceImpl();
        List<Job> jobs = service.getAllJob();
        req.setAttribute("jobs", jobs);
        String page = "/job/job.jsp";
        forwardToPage(page, req, resp);
    }

    private void handleActionCandidateDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.parseLong(req.getParameter("id"));
        CandidateService service = new CandidateServiceImpl();
        Candidate candidate = service.getCandidateDetail(id);
        System.out.println(candidate);
        req.setAttribute("candidate", candidate);
        String page = "/candidate/candidate_detail.jsp";
        forwardToPage(page, req, resp);
    }

    private void handleActionCandidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateService service = new CandidateServiceImpl();
        List<Candidate> candidates = service.getAllCandidate();
        req.setAttribute("candidates", candidates);
        String page = "/candidate/candidate.jsp";
        forwardToPage(page, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if(action == null) {
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action){
                case "insert-candidate":
                    handleInsertCandidate(req, resp);
                    break;
                case "report1":
                    handleReportFillerCandidateByLevel(req,resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleReportFillerCandidateByLevel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int skillLevel = Integer.parseInt(req.getParameter("skillLevel"));
        CandidateService service = new CandidateServiceImpl();
        System.out.println(skillLevel);
        List<Candidate> candidatesByLevel = service.findCandidateBySkillLevel(skillLevel);
        req.setAttribute("candidates", candidatesByLevel);
        String page = "/report/report1.jsp";
        System.out.println(candidatesByLevel);
        forwardToPage(page, req, resp);
    }

    private void handleInsertCandidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lay du lieu tu form
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));

        // lay skill tu form va anh xa no sang SkillLevel enum
        String skillLevelParam = req.getParameter("skillLevel");
        int skillLevelInt = Integer.parseInt(skillLevelParam); // chuyen doi sang so nguyen

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
                throw new IllegalStateException("Unexpected value: " + skillLevelInt);
        }

        // tao doi tuong candidate
        Candidate candidate = new Candidate();
        candidate.setFirst_name(firstName);
        candidate.setMiddle_name(middleName);
        candidate.setLast_name(lastName);
        candidate.setEmail(email);
        candidate.setPhone(phone);
        candidate.setAddress(address);
        candidate.setDob(dob);

        // tao danh sach skill
        List<CandidateSkill> candidateSkills = new ArrayList<>();
        Skill skill = new Skill();
        skill.setId(1L); // Thay đổi ID skill này theo thực tế (ví dụ: lấy từ CSDL hoặc form)

        // tạo candidate skill va gan gia tri
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(candidate);
        candidateSkill.setSkill(skill);
        candidateSkill.setSkillLevel(skillLevel);

        // them candidate skill vao danh sach candidateSkills
        candidateSkills.add(candidateSkill);
        candidate.setCandidateSkills(candidateSkills);

        // goi service de insert
        CandidateService service = new CandidateServiceImpl();
        service.insert(candidate);

        // chuyen huong ve trang candidate
        resp.sendRedirect("/page?action=candidate");
    }
}
/*
 * @ (#) RecruitmentsController.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.controllers;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.enums.SkillLevel;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Company;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.JobSkill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.JobServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.JobSkillServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.SkillServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs.UserDetails;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recruitments")
@PreAuthorize("hasAnyAuthority('COMPANY')")
public class RecruitmentsController {

    @Autowired
    private JobServices jobServices;

    @Autowired
    private SkillServices skillServices;

    @Autowired
    private JobSkillServices jobSkillServices;

    @GetMapping({"", "/dashboard"})
    public String recruitment(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long candidateId = ((UserDetails) authentication.getPrincipal()).getUser().getId();

        int countJob = jobServices.countByCompanyId(candidateId);
        model.addAttribute("countJob", countJob);
        return "recruitments/dashboard";
    }

    @GetMapping("/availableJob")
    public String active(Model model, Principal principal,
                         @RequestParam(defaultValue = "0", required = false) Integer page,
                         @RequestParam(defaultValue = "10", required = false) Integer size) {
        if (principal == null) {
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long candidateId = ((UserDetails) authentication.getPrincipal()).getUser().getId();

        if (page == null) {
            page = 0;
        }

        if (size == null) {
            size = 10;
        }

        Page<Job> pageJobs = jobServices.findByCompanyId(candidateId, page, size);
        model.addAttribute("pageJobs", pageJobs);

        return "recruitments/availableJob";
    }

    @GetMapping("/manageJob")
    public String manageJob(Model model, Principal principal,
                            @RequestParam(defaultValue = "0", required = false) Integer page,
                            @RequestParam(defaultValue = "10", required = false) Integer size) {
        if (principal == null) {
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long candidateId = ((UserDetails) authentication.getPrincipal()).getUser().getId();

        if (page == null) {
            page = 0;
        }

        if (size == null) {
            size = 10;
        }

        Page<Job> pageJobs = jobServices.findByCompanyId(candidateId, page, size);
        model.addAttribute("pageJobs", pageJobs);

        return "recruitments/manageJob";
    }

    @GetMapping("/job/{jobId}")
    public String job(Model model, Principal principal,
                      @PathVariable Long jobId) {
        if (principal == null) {
            return "redirect:/login";
        }
        Job job = jobServices.getJob(jobId);
        model.addAttribute("job", job);
        return "recruitments/detailJob";
    }

    @GetMapping({"/job/edit/{jobId}", "/job/edit"})
    public String editJob(Model model, Principal principal,
                          @PathVariable(required = false) Long jobId,
                          @ModelAttribute Job job,
                          @RequestParam(required = false) String action,
                          @RequestParam(required = false) String skillId,
                          @RequestParam(required = false, defaultValue = "0") Integer num) {
        if (principal == null) {
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long companyId = ((UserDetails) authentication.getPrincipal()).getUser().getId();

        if (jobId != null) {
            job = jobServices.getJob(jobId);
        } else {
            job = new Job();
            job.setCompany(Company.builder().id(companyId).build());
            job.setJobSkills(new ArrayList<>());
        }

        if ("newSkill".equals(action)) {
            for (int i = 0; i < num; i++) {
                JobSkill jobSkill = new JobSkill();
                jobSkill.setSkill(new Skill());
                jobSkill.getSkill().setId((long) -1);
                job.getJobSkills().add(jobSkill);
            }
        } else if ("removeSkill".equals(action)) {
            job.getJobSkills().removeIf(jobSkill -> jobSkill.getSkill().getId().equals(Long.parseLong(skillId)));
        }

        List<Skill> skills = skillServices.getAll();
        List<SkillLevel> skillLevels = List.of(SkillLevel.values());

        model.addAttribute("job", job);
        model.addAttribute("skills", skills);
        model.addAttribute("skillLevels", skillLevels);
        model.addAttribute("num", num);

        return "recruitments/editJob";
    }

    @PostMapping("/job/edit")
    public String editJob(Model model, Principal principal, @ModelAttribute Job job, @RequestParam List<Long> skillIds) {
        if (principal == null) {
            return "redirect:/login";
        }
        try {
            jobServices.createJob(job, skillIds);
            return "redirect:/recruitments/manageJob";
        } catch (Exception e) {
            model.addAttribute("error", "Có lỗi xảy ra khi cập nhật hoặc tạo job");
            return "redirect:/recruitments/availableJob";
        }
    }

}

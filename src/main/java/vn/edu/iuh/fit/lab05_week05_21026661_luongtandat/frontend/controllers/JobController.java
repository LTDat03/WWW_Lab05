/*
 * @ (#) JobController.java       1.0     12/15/2024
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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.*;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.CandidateServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.JobServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs.UserDetails;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobServices jobServices;

    @Autowired
    private CandidateServices candidateServices;

    @GetMapping("/search")
    public String jobSearch(
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "address", required = false) String address,
            Model model
    ) {
        List<Job> job = jobServices.searchJobs(filter, address);
        model.addAttribute("jobs", job);
        return "home/searchJob";
    }

    @GetMapping({"details/{jobId}"})
    public String jobDetail(@PathVariable Long jobId, Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long candidateId = ((UserDetails) authentication.getPrincipal()).getUser().getId();
        List<CandidateSkill> candidate = candidateServices.getSkillByCandidateId(candidateId);
        Job job = jobServices.getJob(jobId);
        Candidate candidate1 = candidateServices.getCandidate(candidateId);
        model.addAttribute("candidate", candidate1);
        model.addAttribute("candidateSkill", candidate);
        model.addAttribute("job", job);
        return "home/details";
    }
}

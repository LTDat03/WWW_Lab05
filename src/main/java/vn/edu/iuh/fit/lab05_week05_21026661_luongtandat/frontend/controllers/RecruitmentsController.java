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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.JobServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs.UserDetails;

import java.security.Principal;

@Controller
@RequestMapping("/recruitments")
@PreAuthorize("hasAnyAuthority('COMPANY')")
public class RecruitmentsController {

    @Autowired
    private JobServices jobServices;

    @GetMapping({"","/dashboard"})
    public String recruitment(Model model, Principal principal){
        if (principal == null){
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long candidateId = ((UserDetails)authentication.getPrincipal()).getUser().getId();

        int countJob = jobServices.countByCompanyId(candidateId);
        model.addAttribute("countJob", countJob);
        return "recruitments/dashboard";
    }

    @GetMapping("/availableJob")
    public String active(Model model, Principal principal,
                         @RequestParam(defaultValue = "0", required = false) Integer page,
                         @RequestParam(defaultValue = "10", required = false) Integer size){
        if (principal == null){
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long candidateId = ((UserDetails)authentication.getPrincipal()).getUser().getId();

        if(page == null){
            page = 0;
        }

        if(size == null){
            size = 10;
        }

        Page<Job> pageJobs = jobServices.findByCompanyId(candidateId, page, size);
        model.addAttribute("pageJobs", pageJobs);

        return "recruitments/availableJob";
    }

    @GetMapping("/manageJob")
    public String manageJob(Model model, Principal principal,
                         @RequestParam(defaultValue = "0", required = false) Integer page,
                         @RequestParam(defaultValue = "10", required = false) Integer size){
        if (principal == null){
            return "redirect:/login";
        }
        Authentication authentication = (Authentication) principal;

        Long candidateId = ((UserDetails)authentication.getPrincipal()).getUser().getId();

        if(page == null){
            page = 0;
        }

        if(size == null){
            size = 10;
        }

        Page<Job> pageJobs = jobServices.findByCompanyId(candidateId, page, size);
        model.addAttribute("pageJobs", pageJobs);

        return "recruitments/manageJob";
    }


}

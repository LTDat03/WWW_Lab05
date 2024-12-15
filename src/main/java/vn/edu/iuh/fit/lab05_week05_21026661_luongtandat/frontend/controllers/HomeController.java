/*
 * @ (#) HomeController.java       1.0     12/14/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.controllers;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/14/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.JobRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.JobServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs.UserDetails;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.utils.RoleUtils;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private JobServices jobServices;

    @GetMapping({"", "/index"})
    public String index(Model model, Principal principal,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        Authentication authentication = (Authentication) principal;
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Job> jobs = jobServices.findAll(currentPage - 1, pageSize, "id", "asc");
        int totalPage = jobs.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumber", pageNumbers);
        }
        if (authentication == null) {
            model.addAttribute("jobs", jobs);
        } else {
            if (authentication.isAuthenticated()) {
                if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(RoleUtils.ROLE_CANDIDATE))) {
                    Long candidateId = ((UserDetails) authentication.getPrincipal()).getUser().getId();
                    model.addAttribute("candidateId", candidateId);
                    model.addAttribute("jobs", jobs);
                } else if (authentication.isAuthenticated()) {
                    if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(RoleUtils.ROLE_COMPANY))) {
                        return "redirect:/recruitments";
                    }
                }
            }
        }
        return "home/index";
    }
}

/*
 * @ (#) AuthController.java       1.0     12/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.controllers;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/12/2024
 */

import com.neovisionaries.i18n.CountryCode;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Candidate;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.User;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.CandidateServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.configs.UserDetails;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private CandidateServices candidateServices;

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "auth/register";
    }

    @GetMapping("/personal")
    @PreAuthorize("hasAnyAuthority('CANDIDATE')")
    public String personal(Model model,
                           Principal principal
    ) {
        Authentication authentication = (Authentication) principal;
        Long candidateId = ((UserDetails) authentication.getPrincipal()).getUser().getId();
        Candidate candidate = candidateServices.getCandidate(candidateId);
        model.addAttribute("candidate", candidate);
        model.addAttribute("address", candidate.getAddress());
        model.addAttribute("countries", CountryCode.values());
        return "home/personal";
    }

}

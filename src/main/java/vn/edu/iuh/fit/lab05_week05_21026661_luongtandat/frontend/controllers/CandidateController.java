/*
 * @ (#) CandidateController.java       1.0     11/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.controllers;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 11/11/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.CandidateServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl.CandidateServiceImpl;

@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateServices candidateServices = new CandidateServiceImpl();

    @GetMapping("/list")
    public String showCandidateList(Model model){
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }
}

/*
 * @ (#) JobController.java       1.0     12/9/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.resources;
 /*
  * @description:
  * @author: Luong Tan Dat
  * @date: 12/9/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.JobRepository;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public String showAllJob(Model model){
        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "job/job";
    }
}

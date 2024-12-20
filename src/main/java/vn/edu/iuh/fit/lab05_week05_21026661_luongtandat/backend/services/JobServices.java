/*
 * @ (#) JobServices.java       1.0     12/9/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;

import java.util.List;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/9/2024
 */
public interface JobServices {
    Page<Job> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);

    List<Job> searchJobs(String filter, String address);

    Integer countByCompanyId(Long companyId);

    Page<Job> findByCompanyId(Long companyId, int pageNo, int pageSize);

    Job getJob(Long jobId);

    Job createJob(Job job, List<Long> skillIds);

}

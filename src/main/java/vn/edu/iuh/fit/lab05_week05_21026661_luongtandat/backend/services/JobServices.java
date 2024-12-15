/*
 * @ (#) JobServices.java       1.0     12/9/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services;

import org.springframework.data.domain.Page;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/9/2024
 */
public interface JobServices {
    Page<Job> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);

    Page<Job> searchJobs(String filter, String address, int pageNo, int pageSize);

    Integer countByCompanyId(Long companyId);

    Page<Job> findByCompanyId(Long companyId, int pageNo, int pageSize);
}

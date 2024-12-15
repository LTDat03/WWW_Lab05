/*
 * @ (#) JobRepository.java       1.0     12/9/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/9/2024
 */

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
    @Query("SELECT COUNT(j) FROM Job j WHERE j.company.id = :companyId")
    int countByCompanyId(Long companyId);

    @Query("SELECT j FROM Job j WHERE j.company.id = :companyId")
    Page<Job> findByCompanyId(Long companyId, Pageable pageable);
}

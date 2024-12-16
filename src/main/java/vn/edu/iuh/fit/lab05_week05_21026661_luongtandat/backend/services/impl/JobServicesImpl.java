/*
 * @ (#) JobServicesImpl.java       1.0     12/9/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/9/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Company;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.JobSkill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.JobRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.JobServices;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.specifications.JobSpecifications;

import java.util.List;
import java.util.Optional;

@Service
public class JobServicesImpl implements JobServices {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;

    @Override
    public Page<Job> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return jobRepository.findAll(pageable);
    }

    @Override
    public List<Job> searchJobs(String filter, String address) {
        Specification<Job> specification = Specification.where(JobSpecifications.hasFilter(filter))
                .and(JobSpecifications.hasAddress(address));
        return jobRepository.findAll(specification);
    }

    @Override
    public Integer countByCompanyId(Long companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        Integer count = 0;

        if (company != null) {
            count = jobRepository.countByCompanyId(company.getId());
        }

        return count;
    }

    @Override
    public Page<Job> findByCompanyId(Long companyId, int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);

        return jobRepository.findByCompanyId(companyId, pageRequest);
    }

    @Override
    public Job getJob(Long jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

    @Override
    public Job createJob(Job job, List<Long> skillIds) {
        if(job.getCompany().getId() == null) {
            return null;
        }

        Job newJob = new Job();

        if(skillIds != null && !skillIds.isEmpty()){
            for(Long skillId : skillIds){
                JobSkill jobSkill = new JobSkill();
                jobSkill.setJob(newJob);
                jobSkill.setSkill(new Skill(skillId));
                jobSkillRepository.save(jobSkill);
            }
        }
        return newJob;
    }

}

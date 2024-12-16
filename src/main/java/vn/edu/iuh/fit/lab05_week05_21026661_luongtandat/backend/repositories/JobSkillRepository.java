/*
 * @ (#) JobSkillRepository.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.JobSkill;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */
@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {
}

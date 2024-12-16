/*
 * @ (#) CandidateSkillRepository.java       1.0     12/16/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.CandidateSkill;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/16/2024
 */
@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Long> {
}

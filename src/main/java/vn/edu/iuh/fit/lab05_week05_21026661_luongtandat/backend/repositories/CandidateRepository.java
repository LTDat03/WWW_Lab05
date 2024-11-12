/*
 * @ (#) CandidateRepository.java       1.0     11/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Candidate;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 11/11/2024
 */

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}

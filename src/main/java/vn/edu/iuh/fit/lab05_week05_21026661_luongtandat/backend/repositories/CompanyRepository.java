/*
 * @ (#) CompanyRepository.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

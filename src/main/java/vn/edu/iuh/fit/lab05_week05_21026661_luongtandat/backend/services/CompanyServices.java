/*
 * @ (#) CompanyServices.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services;

import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Company;

/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */
public interface CompanyServices {
    Company findByJobId(Long jobId);
}

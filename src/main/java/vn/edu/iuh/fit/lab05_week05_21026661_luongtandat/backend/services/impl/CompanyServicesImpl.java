/*
 * @ (#) CompanyServicesImpl.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Company;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.CompanyServices;

@Service
public class CompanyServicesImpl implements CompanyServices {

    @Override
    public Company findByJobId(Long jobId) {
        return null;
    }
}

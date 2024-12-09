/*
 * @ (#) CandidateServices.java       1.0     11/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 11/11/2024
 */

import org.springframework.data.domain.Page;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Candidate;

public interface CandidateServices {
    public Candidate updateCandidate(Candidate candidate);

}

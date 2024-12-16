/*
 * @ (#) SkillServices.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;

import java.util.List;

@Service
public interface SkillServices {
    List<Skill> getAll();
}

/*
 * @ (#) SkillServicesImpl.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.SkillServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServicesImpl implements SkillServices {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }
    
}

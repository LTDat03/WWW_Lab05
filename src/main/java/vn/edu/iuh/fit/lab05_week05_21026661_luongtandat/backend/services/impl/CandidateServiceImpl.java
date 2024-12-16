/*
 * @ (#) CandidateServiceImpl.java       1.0     11/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.impl;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 11/11/2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Address;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Candidate;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.CandidateSkill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.services.CandidateServices;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateServices {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        Candidate candidate1 = null;
        if (candidate.getId() != null) {
            candidate1 = candidateRepository.findById(candidate.getId()).orElse(null);
            if (candidate1 == null) {
                return null;
            } else {
                if (candidate.getFullName() != null) {
                    candidate1.setFullName(candidate.getFullName());
                }
                if (candidate.getEmail() != null) {
                    candidate1.setEmail(candidate.getEmail());
                }
                if (candidate.getPhone() != null) {
                    candidate1.setPhone(candidate.getPhone());
                }
                if (candidate.getDob() != null) {
                    candidate1.setDob(candidate.getDob());
                }
                if (candidate.getAddress() != null) {
                    // Cập nhật Address nếu có
                    Address address = addressRepository.findById(candidate.getAddress().getId()).orElse(null);
                    if (address != null) {
                        candidate.setAddress(address);
                    }
                }
            }
        } else {
            // Nếu không có ID trong candidateDto, tạo mới candidate
            candidate1 = new Candidate();
            candidate1.setFullName(candidate.getFullName());
            candidate1.setEmail(candidate.getEmail());
            candidate1.setPhone(candidate.getPhone());
            candidate1.setDob(candidate.getDob());

            // Tạo mới Address nếu có
            if (candidate.getAddress() != null) {
                Address address = new Address();
                address.setStreet(candidate.getAddress().getStreet());
                address.setCity(candidate.getAddress().getCity());
                address.setZipcode(candidate.getAddress().getZipcode());
                // Lưu Address mới
                address = addressRepository.save(address);
                candidate.setAddress(address);
            }
        }

        Candidate finalCandidate = candidate1;

        if (candidate.getCandidateSkills() != null) {
            candidate.getCandidateSkills().forEach(candidateSkill -> {
                // Tìm kiếm Skill trong cơ sở dữ liệu
                Skill skill = skillRepository.findById(candidateSkill.getSkill().getId()).orElse(null);

                if (skill != null) {
                    CandidateSkill candidateSkill1 = new CandidateSkill();
                    candidateSkill.setCandidate(finalCandidate);
                    candidateSkill.setSkill(skill);
                    candidateSkill.setSkillLevel(candidateSkill.getSkillLevel());
                    candidateSkill.setMoreInfos(candidateSkill.getMoreInfos());

                    candidateSkillRepository.save(candidateSkill);
                }
            });
        }
        return candidateRepository.save(candidate);
    }

    ;


    @Override
    public Candidate getCandidate(Long candidateId) {
        return candidateRepository.findById(candidateId).orElse(null);
    }

    @Override
    public List<CandidateSkill> getSkillByCandidateId(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate != null) {
            return candidate.getCandidateSkills();
        }
        return new ArrayList<>();
    }


}

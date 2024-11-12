/*
 * @ (#) SkillLevel.java       1.0     11/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.enums;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 11/12/2024
 */

import lombok.Getter;
import lombok.Setter;

@Getter
public enum SkillLevel {
    IMMEDIATE(0, "Immediate"),
    PROFESSIONAL(1, "Professional"),
    ADVANCED(2, "Advanced"),
    BEGINNER(3, "Beginner"),
    MASTER(4, "Master");

    private final int code;
    private final String description;

    SkillLevel(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static SkillLevel fromCode(int code) {
        for (SkillLevel level : SkillLevel.values()) {
            if (level.code == code) {
                return level;
            }
        }
        return null;
    }
}

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.enums;

import lombok.Getter;

@Getter
public enum SkillType {
    TECHNICAL_SKILL(0, "Technical Skill"),
    UNSPECIFIC(1, "Unspecific"),
    SOFT_SKILL(2, "Soft Skill");

    private final int code;
    private final String description;

    SkillType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static SkillType of(int code) {
        for (SkillType type : SkillType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }


}

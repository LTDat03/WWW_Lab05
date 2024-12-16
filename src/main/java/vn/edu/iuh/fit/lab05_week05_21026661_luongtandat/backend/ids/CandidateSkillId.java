package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Candidate;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class CandidateSkillId implements Serializable {
    @Column(name = "can_id", nullable = false)
    private Long candidate;
    @Column(name = "skill_id", nullable = false)
    private Long skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillId that = (CandidateSkillId) o;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill);
    }
}
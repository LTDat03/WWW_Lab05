package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Candidate;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Skill;

import java.io.Serializable;
import java.util.Objects;

public class CandidateSkillId implements Serializable {
    private Candidate candidate;
    private Skill skill;

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
package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.enums.SkillLevel;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.ids.JobSkillId;

@Getter
@Setter
@Entity
@Table(name = "job_skill")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(JobSkillId.class)
public class JobSkill {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    private SkillLevel skillLevel;

}
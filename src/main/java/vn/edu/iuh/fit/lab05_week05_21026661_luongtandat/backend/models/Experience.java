package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @Column(name = "experience_id", nullable = false)
    private Long id;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "work_description", nullable = false)
    private String workDescription;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;

}
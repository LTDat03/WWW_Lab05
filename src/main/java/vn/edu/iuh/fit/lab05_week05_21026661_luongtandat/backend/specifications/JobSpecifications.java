/*
 * @ (#) JobSpecifications.java       1.0     12/15/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.specifications;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/15/2024
 */

import org.springframework.data.jpa.domain.Specification;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.Job;

public class JobSpecifications {
    public static Specification<Job> hasFilter(String filter) {
        return (root, query, criteriaBuilder) -> {
            if (filter == null || filter.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("jobName")), "%" + filter.toLowerCase() + "%"),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("company").get("compName")), "%" + filter.toLowerCase() + "%")
            );
        };
    }

    public static Specification<Job> hasAddress(String address) {
        return (root, query, criteriaBuilder) -> {
            if (address == null || address.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("company").get("address").get("city")), "%" + address.toLowerCase() + "%");
        };
    }
}

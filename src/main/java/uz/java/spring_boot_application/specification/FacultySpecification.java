package uz.java.spring_boot_application.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import uz.java.spring_boot_application.dto.faculty.FacultyFilter;
import uz.java.spring_boot_application.entities.Faculty;

import java.util.ArrayList;
import java.util.List;

public record FacultySpecification(FacultyFilter filter) implements Specification<Faculty> {
    @Override
    public  Predicate toPredicate(Root<Faculty> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getName() != null)
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));

        if (filter.getUniversityId() != null)
            predicates.add(criteriaBuilder.equal(root.get("university").get("id"), filter.getUniversityId()));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

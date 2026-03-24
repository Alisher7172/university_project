package uz.java.spring_boot_application.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import uz.java.spring_boot_application.dto.subject.SubjectFilter;
import uz.java.spring_boot_application.entities.Subjects;

import java.util.ArrayList;
import java.util.List;

public record SubjectSpecification(SubjectFilter filter) implements Specification<Subjects> {
    @Override
    public Predicate toPredicate(Root<Subjects> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getName() != null)
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + filter.getName().toUpperCase() + "%"));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

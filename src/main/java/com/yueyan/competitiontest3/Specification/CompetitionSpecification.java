package com.yueyan.competitiontest3.Specification;

import com.yueyan.competitiontest3.pojo.Competition;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CompetitionSpecification {


    public static Specification<Competition> yearEquals(String year){
        return((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(year!=null){
                predicates.add(builder.equal(root.get(Competition_.year),year));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };


    }
}

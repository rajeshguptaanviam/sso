package com.eclipseeio.emi.model.specifications;


import com.eclipseeio.emi.model.User;
import org.springframework.data.jpa.domain.Specification;
//import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<User> {

    private String filter;

    public UserSpecification(String filter) {
        this.filter = filter;
    }

    //@Nullable
    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        Predicate p = cb.disjunction();

        if (filter != null) {
            p.getExpressions().add(
                    cb.or(
                            cb.like(cb.lower(root.get("firstname")), "%" + filter + "%"),
                            cb.like(cb.lower(root.get("lastname")), "%" + filter + "%"),
                            cb.like(cb.lower(root.get("email")), "%" + filter + "%")

                    )
            );
        }
        return p;
    }
}

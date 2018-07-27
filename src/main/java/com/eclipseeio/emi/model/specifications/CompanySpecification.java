package com.eclipseeio.emi.model.specifications;


import com.eclipseeio.emi.model.CallDetail;
import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.User;
import org.springframework.data.jpa.domain.Specification;
//import org.springframework.lang.Nullable;

import javax.persistence.criteria.*;

@SuppressWarnings("serial")
public class CompanySpecification implements Specification<Company> {

    private String filter;

    public CompanySpecification(String filter) {
        this.filter = filter;
    }

    //@Nullable
    @Override
    public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        Predicate p = cb.disjunction();

        if (filter != null) {
            Join<Company, User> enquiryUserJoin = root.join("user", JoinType.LEFT);
            p.getExpressions().add(
                    cb.or(
                            cb.like(cb.lower(root.get("companyName")), "%" + filter.toLowerCase() + "%")
                            , cb.like(cb.lower(root.get("contactName")), "%" + filter.toLowerCase() + "%")
                            , cb.like(cb.lower(enquiryUserJoin.get("firstName")), "%" + filter.toLowerCase() + "%")

                    )
            );
        }


        return p;
    }

}

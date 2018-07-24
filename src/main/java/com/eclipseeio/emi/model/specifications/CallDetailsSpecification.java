package com.eclipseeio.emi.model.specifications;


import com.eclipseeio.emi.model.CallDetail;
import com.eclipseeio.emi.model.CallTopic;
import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

//import org.springframework.lang.Nullable;

@SuppressWarnings("serial")
public class CallDetailsSpecification implements Specification<CallDetail> {

    private String filter;

    public CallDetailsSpecification(String filter) {
        this.filter = filter;
    }

    // @Nullable
    @Override
    public Predicate toPredicate(Root<CallDetail> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        Predicate p = cb.disjunction();
        Join<CallDetail, User> enquiryUserJoin = root.join("user", JoinType.LEFT);
        Join<CallDetail, Company> enquiryCompanyJoin_ = root.join("company", JoinType.LEFT);
        Join<CallDetail, CallTopic> enquiryCallTopicJoin_ = root.join("callTopic", JoinType.LEFT);

        if (filter != null) {

            p.getExpressions().add(
                    cb.or(
                            cb.like(cb.lower(enquiryCompanyJoin_.get("companyName")), "%" + filter.toLowerCase() + "%"),
                            cb.like(cb.lower(enquiryUserJoin.get("firstName")), "%" + filter.toLowerCase() + "%"),
                            cb.like(cb.lower(enquiryUserJoin.get("email")), "%" + filter.toLowerCase() + "%"),
                            cb.like(cb.lower(enquiryCallTopicJoin_.get("callTopicName")), "%" + filter.toLowerCase() + "%")


                    )
            );
        }


        return p;
    }

}

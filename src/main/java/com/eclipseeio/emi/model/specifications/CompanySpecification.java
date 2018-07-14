package com.eclipseeio.emi.model.specifications;


import com.eclipseeio.emi.model.Company;
import org.springframework.data.jpa.domain.Specification;
//import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@SuppressWarnings("serial")
public class CompanySpecification implements Specification<Company> {

    private String filter;

    public CompanySpecification(String filter) {
        this.filter = filter;
    }
   // @Nullable
    @Override
    public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        Predicate p = cb.disjunction();

        if (filter != null) {

		    p.getExpressions().add(
		    		 cb.or(
                                    cb.like(cb.lower(root.get("companyName")), "%" + filter.toLowerCase() + "%")
		                    ,       cb.like(cb.lower(root.get("contactName")),"%"+ filter.toLowerCase()+"%")

		            )
		    );
		}
        

        return p;
    }

}

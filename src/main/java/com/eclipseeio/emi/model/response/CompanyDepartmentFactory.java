package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.CompanyDepartment;

public final class CompanyDepartmentFactory {

    private CompanyDepartmentFactory() {

    }

    public static CompanyDepartmentResponse create(CompanyDepartment companyDepartment) {
        return new CompanyDepartmentResponse(companyDepartment);

    }
}




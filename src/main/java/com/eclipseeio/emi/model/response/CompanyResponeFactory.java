package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.Company;

public final class CompanyResponeFactory {

    private CompanyResponeFactory() {

    }

    public static CompanyResponse create(Company company) {
        return new CompanyResponse(company);

    }
}




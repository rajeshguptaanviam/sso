package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.Company;

public final class CallDetailsResponeFactory {

    private CallDetailsResponeFactory() {

    }

    public static CompanyResponse create(Company enquiry) {
        return new CompanyResponse(enquiry);

    }
}




package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.Benefits;
import com.eclipseeio.emi.model.Company;

public final class BenifitesResponeFactory {

    private BenifitesResponeFactory() {

    }

    public static BenifitesResponse create(Benefits benefits) {
        return new BenifitesResponse(benefits);

    }
}




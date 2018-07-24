package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.Organizations;

public final class OrganizationsResponeFactory {

    private OrganizationsResponeFactory() {

    }

    public static OrganizationResponse create(Organizations organizations) {
        return new OrganizationResponse(organizations);

    }
}




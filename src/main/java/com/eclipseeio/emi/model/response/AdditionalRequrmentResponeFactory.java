package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.AdditionalRequirements;
import com.eclipseeio.emi.model.Company;

public final class AdditionalRequrmentResponeFactory {

    private AdditionalRequrmentResponeFactory() {

    }

    public static AdditionalRequementResponse create(AdditionalRequirements enquiry) {
        return new AdditionalRequementResponse(enquiry);

    }
}




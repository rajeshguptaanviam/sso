package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.Industry;

public final class IndustryResponeFactory {

    private IndustryResponeFactory() {

    }

    public static IndustryResponse create(Industry enquiry) {
        return new IndustryResponse(enquiry);

    }
}




package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.Company;
import com.eclipseeio.emi.model.States;

public final class StatesResponeFactory {

    private StatesResponeFactory() {

    }

    public static StatesResponse create(States enquiry) {
        return new StatesResponse(enquiry);

    }
}




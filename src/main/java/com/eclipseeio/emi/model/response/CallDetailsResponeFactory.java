package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.CallDetail;
import com.eclipseeio.emi.model.Company;

public final class CallDetailsResponeFactory {

    private CallDetailsResponeFactory() {

    }

    public static CallDetailsResponse create(CallDetail callDetail) {
        return new CallDetailsResponse(callDetail);

    }
}




package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.AssignTo;
import com.eclipseeio.emi.model.Company;

public final class AssignToResponeFactory {

    private AssignToResponeFactory() {

    }

    public static AssignResponse create(AssignTo assignTo) {
        return new AssignResponse(assignTo);

    }
}




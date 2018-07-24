package com.eclipseeio.emi.model.response;


import com.eclipseeio.emi.model.CallTopic;
import com.eclipseeio.emi.model.Industry;

public final class CallTopicResponeFactory {

    private CallTopicResponeFactory() {

    }

    public static CallTopicResponse create(CallTopic callTopic) {
        return new CallTopicResponse(callTopic);

    }
}




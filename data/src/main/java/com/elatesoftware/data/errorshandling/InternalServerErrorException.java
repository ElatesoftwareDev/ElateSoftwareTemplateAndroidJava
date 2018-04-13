package com.elatesoftware.data.errorshandling;

import java.io.IOException;

public class InternalServerErrorException extends IOException {

    private String internalMessage;
    private String publicMessage;

    InternalServerErrorException(String internalMessage, String publicMessage) {
        this.internalMessage = internalMessage;
        this.publicMessage = publicMessage;
    }

    public String getInternalMessage() {
        return internalMessage;
    }

    public String getPublicMessage() {
        return publicMessage;
    }
}

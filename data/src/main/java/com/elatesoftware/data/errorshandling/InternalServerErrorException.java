package com.elatesoftware.data.errorshandling;

import java.io.IOException;

/**
 * Created by Андрей Евтухов on 12.04.2018.
 */

public class InternalServerErrorException extends IOException {

    private String internalMessage;
    private String publicMessage;

    public InternalServerErrorException(String internalMessage, String publicMessage) {
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

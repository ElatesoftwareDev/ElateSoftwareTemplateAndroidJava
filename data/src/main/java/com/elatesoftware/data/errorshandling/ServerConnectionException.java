package com.elatesoftware.data.errorshandling;

import java.io.IOException;


public class ServerConnectionException extends IOException {

    ServerConnectionException(String message) {
        super(message);
    }
}

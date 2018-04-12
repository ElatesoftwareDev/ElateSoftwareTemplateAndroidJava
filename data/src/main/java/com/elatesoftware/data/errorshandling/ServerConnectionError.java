package com.elatesoftware.data.errorshandling;

import java.io.IOException;

/**
 * Created by Андрей Евтухов on 12.04.2018.
 */

public class ServerConnectionError extends IOException {

    public ServerConnectionError(String message) {
        super(message);
    }
}

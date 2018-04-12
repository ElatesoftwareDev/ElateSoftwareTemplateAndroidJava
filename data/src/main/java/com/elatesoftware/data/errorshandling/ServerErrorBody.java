package com.elatesoftware.data.errorshandling;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Андрей Евтухов on 12.04.2018.
 */

public class ServerErrorBody {

    @SerializedName("message")
    String message;

    @SerializedName("code")
    int code;

    public ServerErrorBody(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
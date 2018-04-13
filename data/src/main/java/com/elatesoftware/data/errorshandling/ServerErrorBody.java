package com.elatesoftware.data.errorshandling;

import com.google.gson.annotations.SerializedName;


class ServerErrorBody {

    @SerializedName("Message")
    String message;

    @SerializedName("Code")
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

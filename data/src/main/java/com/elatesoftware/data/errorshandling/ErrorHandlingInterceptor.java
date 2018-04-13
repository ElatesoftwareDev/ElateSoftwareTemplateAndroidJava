package com.elatesoftware.data.errorshandling;

import android.content.Context;
import android.text.TextUtils;

import com.elatesoftware.data.R;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Singleton
public class ErrorHandlingInterceptor implements Interceptor {

    private static final int HTTP_CLIENT_ERROR_CODE = 400;
    private static final int HTTP_SERVER_ERROR_CODE = 500;

    private static final int INTERNAL_EMAIL_OR_PASSWORD_IS_INCORRECT = 106;

    private final Context context;
    private final Gson gson;

    @Inject
    ErrorHandlingInterceptor(Context context) {
        this.context = context;
        this.gson = new Gson();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        try {
            Request request = chain.request();
            okhttp3.Response response = chain.proceed(request);
            if (!response.isSuccessful()) {
                switch (response.code()) {
                    case HTTP_CLIENT_ERROR_CODE:
                        handleClientError(response);
                    case HTTP_SERVER_ERROR_CODE:
                        handleServerError();
                }
            }
            return response;
        } catch (SocketTimeoutException e) {
            throw new ServerConnectionException(context.getString(R.string.error_handling_timeout));
        } catch (UnknownHostException | ConnectException e) {
            throw new ServerConnectionException(context.getString(R.string.error_no_connection));
        }
    }


    private void handleServerError() throws UnknownServerException {
        throw new UnknownServerException();
    }

    private void handleClientError(okhttp3.Response response) throws IOException {
        try {
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                String errorBody = responseBody.string();
                if (!TextUtils.isEmpty(errorBody)) {
                    ServerErrorBody error = gson.fromJson(errorBody, ServerErrorBody.class);
                    if (error != null) {
                        throw getExceptionFromError(error);
                    }
                }
            }
            throw getUnknownInternalException();
        } catch (JsonSyntaxException e) {
            throw getUnknownInternalException();
        }
    }

    private IOException getExceptionFromError(ServerErrorBody error) {
        switch (error.getCode()) {
            case INTERNAL_EMAIL_OR_PASSWORD_IS_INCORRECT:
                return new InternalServerErrorException(error.getMessage(),
                        context.getString(R.string.error_internal_error_password_or_email));
            default:
                return getUnknownInternalException();
        }
    }

    private IOException getUnknownInternalException() {
        return new IOException(context.getString(R.string.error_unhandled_server_error));
    }

}

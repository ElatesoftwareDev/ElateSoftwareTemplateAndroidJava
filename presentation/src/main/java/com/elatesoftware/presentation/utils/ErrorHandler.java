package com.elatesoftware.presentation.utils;

import android.content.Context;
import android.text.TextUtils;

import com.elatesoftware.data.errorshandling.InternalServerErrorException;
import com.elatesoftware.data.errorshandling.ServerConnectionException;
import com.elatesoftware.data.errorshandling.UnhandledInternalServerException;
import com.elatesoftware.data.errorshandling.UnknownServerException;
import com.elatesoftware.presentation.R;

import java.io.IOException;

public class ErrorHandler {

    private final Context context;
    private final ErrorHandlerCallback errorHandlerCallback;

    public interface ErrorHandlerCallback {
        void showMessage(String message);
    }

    public ErrorHandler(Context context, ErrorHandlerCallback errorHandlerCallback) {
        this.context = context;
        this.errorHandlerCallback = errorHandlerCallback;
    }

    public void handleError(Throwable throwable) {
        if (throwable instanceof InternalServerErrorException) {
            onInternalServerError((InternalServerErrorException) throwable);
        } else if (throwable instanceof ServerConnectionException) {
            onServerConnectionError((ServerConnectionException) throwable);
        } else if (throwable instanceof UnhandledInternalServerException) {
            onUnhandledInternalServerException();
        } else if (throwable instanceof UnknownServerException) {
            onUnknownServerError((UnknownServerException) throwable);
        } else if (throwable instanceof IOException) {
            onUnknownIoException();
        } else if (throwable instanceof Exception) {
            onUnknownException((Exception) throwable);
        }
    }

    private void onInternalServerError(InternalServerErrorException e) {
        if (!TextUtils.isEmpty(e.getPublicMessage())) {
            errorHandlerCallback.showMessage(e.getPublicMessage());
        } else {
            if (!TextUtils.isEmpty(e.getInternalMessage())) {
                errorHandlerCallback.showMessage(e.getInternalMessage());
            } else {
                onUnhandledInternalServerException();
            }
        }
    }

    private void onServerConnectionError(ServerConnectionException e) {
        if (!TextUtils.isEmpty(e.getMessage())) {
            errorHandlerCallback.showMessage(e.getMessage());
        } else {
            onUnhandledInternalServerException();
        }
    }

    private void onUnhandledInternalServerException() {
        errorHandlerCallback.showMessage(context.getString(R.string.error_unhandled_server_error));
    }

    private void onUnknownServerError(UnknownServerException e) {
        if (!TextUtils.isEmpty(e.getMessage())) {
            errorHandlerCallback.showMessage(e.getMessage());
        } else {
            onUnhandledInternalServerException();
        }
    }

    private void onUnknownIoException() {
        errorHandlerCallback.showMessage(context.getString(R.string.error_ioexception));
    }

    private void onUnknownException(Exception e) {
        errorHandlerCallback.showMessage(context.getString(R.string.error_unhandled_error));
    }
}
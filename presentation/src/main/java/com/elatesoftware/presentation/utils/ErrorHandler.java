package com.elatesoftware.presentation.utils;

import android.content.Context;

import javax.inject.Inject;

// TODO: 12.04.2018 не должен ли быть он синглетоном, нужно замутить работы с хэндлером через интерфейс
    public class ErrorHandler {

    private static final int HTTP_CLIENT_ERROR_CODE = 400;
    private static final int HTTP_SERVER_ERROR_CODE = 500;

    private static final int INTERNAL_EXAMPLE_CODE = 228;

    private final Context context;

    @Inject
    public ErrorHandler(Context context) {
        this.context = context;
    }

    public String getErrorMessage(Throwable throwable) {
//        if (throwable instanceof HttpException) {
//            return getErrorMessage(context, (HttpException) throwable);
//        } else if (throwable instanceof SocketTimeoutException) {
//            return context.getString(R.string.error_handling_timeout);
//        } else if (throwable instanceof IOException) {
//            return context.getString(R.string.error_handling_network_error);
//        } else {
            return throwable.getMessage();
      //  }
    }

//    private String getErrorMessage(Context context, HttpException httpException) {
//        switch (httpException.code()) {
//            case HTTP_CLIENT_ERROR_CODE:
//                return onClientError(context, httpException);
//            case HTTP_SERVER_ERROR_CODE:
//                return onServerError(context, httpException);
//            default:
//                return context.getString(R.string.error_unknown);
//        }
//    }
//
//    private String onServerError(Context context, HttpException httpException) {
//        return context.getString(R.string.error_unknown);
//    }
//
//    private String onClientError(Context context, HttpException httpException) {
//        try {
//            ResponseBody responseBody = httpException.response().errorBody();
//            Gson throwable = new Gson();
//            ErrorBody errorBody = throwable.fromJson(responseBody.string(), ErrorBody.class);
//            switch (errorBody.getCode()) {
//                default:
//                case INTERNAL_EXAMPLE_CODE:
//                    return context.getString(R.string.error_courses_end);
//            }
//        } catch (JsonSyntaxException | IOException e) {
//            return context.getString(R.string.error_server_communication);
//        } catch (Exception e) {
//            return context.getString(R.string.error_unknown);
//        }
//    }



}
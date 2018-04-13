package com.elatesoftware.presentation.features.base;

import android.content.Context;

import com.arellomobile.mvp.MvpPresenter;
import com.elatesoftware.presentation.utils.ErrorHandler;

import javax.inject.Inject;

abstract public class BasePresenter<V extends BaseView> extends MvpPresenter<V> implements ErrorHandler.ErrorHandlerCallback {

    @Inject
    protected Context context;

    private ErrorHandler errorHandler;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        errorHandler = new ErrorHandler(context, this);
    }

    protected void handleError(Throwable e) {
        errorHandler.handleError(e);
    }

    @Override
    public void showMessage(String message) {
        getViewState().showToast(message);
    }
}

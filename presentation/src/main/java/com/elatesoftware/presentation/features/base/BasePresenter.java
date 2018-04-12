package com.elatesoftware.presentation.features.base;

import android.content.Context;

import com.arellomobile.mvp.MvpPresenter;
import com.elatesoftware.presentation.utils.ErrorHandler;

import javax.inject.Inject;

/**
 * Created by Андрей Евтухов on 12.04.2018.
 */

public class BasePresenter<V extends BaseView> extends MvpPresenter<V> {

    @Inject
    protected Context context;
    @Inject
    ErrorHandler errorHandler;

    protected void handleError(Throwable e) {
        getViewState().showToast(errorHandler.getErrorMessage(e));
    }

}

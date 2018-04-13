package com.elatesoftware.presentation.features.base;

import com.arellomobile.mvp.MvpView;

public interface BaseView extends MvpView {
    //todo разобраться со стратегиями
    void showToast(String message);

}

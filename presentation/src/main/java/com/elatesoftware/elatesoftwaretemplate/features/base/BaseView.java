package com.elatesoftware.elatesoftwaretemplate.features.base;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public interface BaseView extends MvpView {
    //todo разобраться со стратегиями
    void showToast(String message);

}

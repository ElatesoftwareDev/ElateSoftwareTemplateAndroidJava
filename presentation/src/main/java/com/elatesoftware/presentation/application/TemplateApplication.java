package com.elatesoftware.presentation.application;

import android.app.Application;

import com.arellomobile.mvp.MvpFacade;
import com.elatesoftware.presentation.di.Injector;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public class TemplateApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.getInstance().initializeAppComponent(this);
        MvpFacade.init();
    }

}

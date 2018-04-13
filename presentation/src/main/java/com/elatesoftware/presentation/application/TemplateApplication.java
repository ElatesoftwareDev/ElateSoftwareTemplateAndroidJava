package com.elatesoftware.presentation.application;

import android.app.Application;

import com.arellomobile.mvp.MvpFacade;
import com.elatesoftware.presentation.di.Injector;
import com.squareup.leakcanary.LeakCanary;

public class TemplateApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.getInstance().initializeAppComponent(this);
        initializeLeakDetection();
        MvpFacade.init();
    }

    private void initializeLeakDetection() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}

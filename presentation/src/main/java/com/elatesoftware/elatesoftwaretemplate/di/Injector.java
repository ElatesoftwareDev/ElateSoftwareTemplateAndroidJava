package com.elatesoftware.elatesoftwaretemplate.di;

import android.app.Application;

import com.elatesoftware.elatesoftwaretemplate.di.components.AppComponent;
import com.elatesoftware.elatesoftwaretemplate.di.modules.AppModule;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public class Injector {

    private static final Injector injector = new Injector();

    public static Injector getInstance() {
        return injector;
    }

    private AppComponent appComponent;

    private Injector() {}

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initializeAppComponent(Application application) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}

package com.elatesoftware.elatesoftwaretemplate.di;

import android.app.Application;

import com.elatesoftware.elatesoftwaretemplate.di.components.AppComponent;
import com.elatesoftware.elatesoftwaretemplate.di.components.AuthByEmailComponent;
import com.elatesoftware.elatesoftwaretemplate.di.components.DaggerAppComponent;
import com.elatesoftware.elatesoftwaretemplate.di.components.LaunchComponent;
import com.elatesoftware.elatesoftwaretemplate.di.modules.AppModule;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public class Injector {

    private static final Injector injector = new Injector();

    private AppComponent appComponent;
    private AuthByEmailComponent authByEmailComponent;
    private LaunchComponent launchComponent;

    public static Injector getInstance() {
        return injector;
    }

    private Injector() {}

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initializeAppComponent(Application application) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    public AuthByEmailComponent plusAuthByEmailComponent() {
        if (authByEmailComponent == null) {
            plusLaunchComponent();
            authByEmailComponent = launchComponent.plusAuthByEmailComponent();
        }
        return authByEmailComponent;
    }

    public void clearAuthByEmailComponent() {
        authByEmailComponent = null;
    }

    public LaunchComponent plusLaunchComponent() {
        if (launchComponent == null) {
            launchComponent = appComponent.plusLaunchComponent();
        }
        return launchComponent;
    }

    public void clearLaunchComponent() {
        launchComponent = null;
    }


}

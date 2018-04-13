package com.elatesoftware.presentation.di;

import android.app.Application;

import com.elatesoftware.presentation.di.components.AppComponent;
import com.elatesoftware.presentation.di.components.AuthByEmailComponent;
import com.elatesoftware.presentation.di.components.DaggerAppComponent;
import com.elatesoftware.presentation.di.components.MainComponent;
import com.elatesoftware.presentation.di.modules.AppModule;

public class Injector {

    private static final Injector injector = new Injector();

    private AppComponent appComponent;
    private AuthByEmailComponent authByEmailComponent;
    private MainComponent mainComponent;

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
            authByEmailComponent = appComponent.plusAuthByEmailComponent();
        }
        return authByEmailComponent;
    }

    public void clearAuthByEmailComponent() {
        authByEmailComponent = null;
    }

    public MainComponent plusMainComponent() {
        if (mainComponent == null) {
            mainComponent = appComponent.plusMainComponent();
        }
        return mainComponent;
    }

    public void clearMainComponent() {
        mainComponent = null;
    }


}

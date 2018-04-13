package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.AppModule;
import com.elatesoftware.presentation.di.modules.RestModule;
import com.elatesoftware.presentation.features.launch.LaunchActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RestModule.class})
public interface AppComponent {

    void inject(LaunchActivity activity);

    AuthByEmailComponent plusAuthByEmailComponent();

    MainComponent plusMainComponent();
}


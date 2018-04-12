package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.AppModule;
import com.elatesoftware.presentation.di.modules.RepositoryModule;
import com.elatesoftware.presentation.di.modules.RestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class, RestModule.class})
public interface AppComponent {
    LaunchComponent plusLaunchComponent();
}


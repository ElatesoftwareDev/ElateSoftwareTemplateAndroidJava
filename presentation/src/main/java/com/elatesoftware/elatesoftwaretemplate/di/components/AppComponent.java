package com.elatesoftware.elatesoftwaretemplate.di.components;

import com.elatesoftware.elatesoftwaretemplate.di.modules.AppModule;
import com.elatesoftware.elatesoftwaretemplate.di.modules.RepositoryModule;
import com.elatesoftware.elatesoftwaretemplate.di.modules.RestModule;

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


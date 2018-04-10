package com.elatesoftware.elatesoftwaretemplate.di.components;

import com.elatesoftware.elatesoftwaretemplate.authemail.AuthByEmailActivity;
import com.elatesoftware.elatesoftwaretemplate.di.modules.AppModule;
import com.elatesoftware.elatesoftwaretemplate.di.modules.RestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

@Singleton
@Component(modules = {AppModule.class, RestModule.class})
public interface AppComponent {

    void inject(AuthByEmailActivity authByEmailActivity);
}


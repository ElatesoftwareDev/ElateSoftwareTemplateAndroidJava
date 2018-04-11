package com.elatesoftware.elatesoftwaretemplate.di.modules;

import android.content.Context;

import com.elatesoftware.data.repository.Repository;
import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context appContext;

    public AppModule(Context context) {
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return appContext;
    }
}

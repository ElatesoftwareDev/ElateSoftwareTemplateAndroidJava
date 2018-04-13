package com.elatesoftware.presentation.di.modules;

import com.elatesoftware.data.local.preferences.IPreferencesStorage;
import com.elatesoftware.data.local.preferences.PreferencesStorage;
import com.elatesoftware.data.repository.Repository;
import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoryModule {

    @Binds
    @Singleton
    IRepository provideIRepository(Repository repository);

    @Binds
    @Singleton
    IPreferencesStorage providePreferencesStorage(PreferencesStorage preferencesStorage);

}

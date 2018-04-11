package com.elatesoftware.elatesoftwaretemplate.di.modules;

import com.elatesoftware.data.repository.Repository;
import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */
@Module
public interface RepositoryModule {

    @Binds
    @Singleton
    IRepository provideIRepository(Repository repository);

}

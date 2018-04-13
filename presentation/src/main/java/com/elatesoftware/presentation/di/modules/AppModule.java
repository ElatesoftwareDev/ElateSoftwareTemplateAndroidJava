package com.elatesoftware.presentation.di.modules;

import android.content.Context;

import com.elatesoftware.data.local.preferences.IPreferencesStorage;
import com.elatesoftware.data.local.preferences.PreferencesStorage;
import com.elatesoftware.data.repository.Repository;
import com.elatesoftware.data.threads.JobExecutor;
import com.elatesoftware.domain.executor.ExecutionThread;
import com.elatesoftware.domain.executor.PostExecutionThread;
import com.elatesoftware.domain.repository.IRepository;
import com.elatesoftware.presentation.threads.UIThread;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = AppModule.InnerAppModule.class)
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

    @Module
    public interface InnerAppModule {

        @Binds
        @Singleton
        ExecutionThread provideExecutionThread(JobExecutor jobExecutor);

        @Binds
        @Singleton
        PostExecutionThread providePostExecutionThread(UIThread uiThread);

        @Binds
        @Singleton
        IRepository provideIRepository(Repository repository);

        @Binds
        @Singleton
        IPreferencesStorage provideIPreferencesStorage(PreferencesStorage preferencesStorage);
    }
}

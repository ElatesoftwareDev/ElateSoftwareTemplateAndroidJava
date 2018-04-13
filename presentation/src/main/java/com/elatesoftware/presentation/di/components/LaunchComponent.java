package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.LaunchModule;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;
import com.elatesoftware.presentation.features.launch.LaunchActivity;

import dagger.Subcomponent;

@PerActivity(LaunchActivity.class)
@Subcomponent(modules = LaunchModule.class)
public interface LaunchComponent {

    void inject(LaunchActivity activity);

    AuthByEmailComponent plusAuthByEmailComponent();

    MainComponent plusMainComponent();
}


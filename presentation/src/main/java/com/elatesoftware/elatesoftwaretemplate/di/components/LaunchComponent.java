package com.elatesoftware.elatesoftwaretemplate.di.components;

import com.elatesoftware.elatesoftwaretemplate.di.modules.LaunchModule;
import com.elatesoftware.elatesoftwaretemplate.di.scopeannotations.PerActivity;
import com.elatesoftware.elatesoftwaretemplate.features.launch.LaunchActivity;

import dagger.Subcomponent;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

@PerActivity(LaunchActivity.class)
@Subcomponent(modules = LaunchModule.class)
public interface LaunchComponent {

    void inject(LaunchActivity activity);

    AuthByEmailComponent plusAuthByEmailComponent();
}


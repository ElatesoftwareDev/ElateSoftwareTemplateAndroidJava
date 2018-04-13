package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.MainModule;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;
import com.elatesoftware.presentation.features.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

@PerActivity(MainActivity.class)
@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);
}


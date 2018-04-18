package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.MainModule;
import com.elatesoftware.presentation.di.annotations.PerActivity;
import com.elatesoftware.presentation.features.main.MainActivity;

import dagger.Subcomponent;

@PerActivity(MainActivity.class)
@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);

    ChatComponent plusChatComponent();

    DescriptionComponent plusDescriptionComponent();
}


package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.ChatModule;
import com.elatesoftware.presentation.di.annotations.PerFragment;
import com.elatesoftware.presentation.features.chat.ChatFragment;

import dagger.Subcomponent;

@PerFragment(ChatFragment.class)
@Subcomponent(modules = ChatModule.class)
public interface ChatComponent {

    void inject(ChatFragment fragment);

}


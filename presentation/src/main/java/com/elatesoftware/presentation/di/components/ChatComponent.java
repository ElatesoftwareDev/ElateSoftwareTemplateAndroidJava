package com.elatesoftware.presentation.di.components;

import com.elatesoftware.presentation.di.modules.ChatModule;
import com.elatesoftware.presentation.di.modules.MainModule;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;
import com.elatesoftware.presentation.di.scopeannotations.PerFragment;
import com.elatesoftware.presentation.features.chat.ChatFragment;
import com.elatesoftware.presentation.features.main.MainActivity;

import dagger.Subcomponent;

@PerFragment(ChatFragment.class)
@Subcomponent(modules = ChatModule.class)
public interface ChatComponent {

    void inject(ChatFragment fragment);

}


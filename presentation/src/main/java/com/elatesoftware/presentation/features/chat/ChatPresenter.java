package com.elatesoftware.presentation.features.chat;

import com.arellomobile.mvp.InjectViewState;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.scopeannotations.PerFragment;
import com.elatesoftware.presentation.features.base.BasePresenter;

import javax.inject.Inject;

@InjectViewState
@PerFragment(ChatFragment.class)
public class ChatPresenter extends BasePresenter<ChatView> {

    @Inject
    ChatPresenter() { }

    @Override
    protected void clearComponent() {
        Injector.getInstance().clearChatComponent();
    }
}

package com.elatesoftware.presentation.features.chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.elatesoftware.presentation.R;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.features.base.BaseFragment;

import javax.inject.Inject;
import javax.inject.Provider;


public class ChatFragment extends BaseFragment implements ChatView {

    @InjectPresenter
    ChatPresenter presenter;
    @Inject
    Provider<ChatPresenter> presenterProvider;

    @ProvidePresenter
    ChatPresenter providePresenter() {
        return presenterProvider.get();
    }

    public static Fragment getInstance(){
        return new ChatFragment();
    }

    public ChatFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    protected void injectComponent() {
        Injector.getInstance().plusChatComponent().inject(this);
    }
}

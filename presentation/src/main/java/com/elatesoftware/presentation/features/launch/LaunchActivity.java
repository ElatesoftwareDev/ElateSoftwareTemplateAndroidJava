package com.elatesoftware.presentation.features.launch;

import android.content.Intent;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.features.base.BaseActivity;

import javax.inject.Inject;
import javax.inject.Provider;

public class LaunchActivity extends BaseActivity implements LaunchView {

    @InjectPresenter
    LaunchPresenter presenter;
    @Inject
    Provider<LaunchPresenter> presenterProvider;

    @ProvidePresenter
    LaunchPresenter providePresenter() {
        return presenterProvider.get();
    }

    @Override
    protected void injectComponent() {
        Injector.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void startNextActivity(Intent intent) {
        startActivity(intent);
        finish();
    }
}

package com.elatesoftware.elatesoftwaretemplate.features.launch;

import android.content.Intent;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.elatesoftware.elatesoftwaretemplate.di.Injector;
import com.elatesoftware.elatesoftwaretemplate.features.base.BaseActivity;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

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
        Injector.getInstance().plusLaunchComponent().inject(this);
    }

    @Override
    public void startNextActivity(Intent intent) {
        startActivity(intent);
        finish();
    }
}

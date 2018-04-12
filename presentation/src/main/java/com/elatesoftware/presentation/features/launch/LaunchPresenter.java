package com.elatesoftware.presentation.features.launch;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.elatesoftware.domain.interactors.LaunchInteractor;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;
import com.elatesoftware.presentation.features.authemail.AuthByEmailActivity;
import com.elatesoftware.presentation.features.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

@PerActivity(LaunchActivity.class)
@InjectViewState
public class LaunchPresenter extends BasePresenter<LaunchView> {

    private final Context context;
    private final LaunchInteractor interactor;

    @Inject
    LaunchPresenter(Context context, LaunchInteractor interactor) {
        this.context = context;
        this.interactor = interactor;
    }

    @Override
    public void attachView(LaunchView view) {
        super.attachView(view);
        showNextActivity();
    }

    private void showNextActivity() {
        if (interactor.isAuth()) {
            getViewState().startNextActivity(AuthByEmailActivity.getActivityIntent(context));
        } else {
            getViewState().startNextActivity(AuthByEmailActivity.getActivityIntent(context));
        }
    }

    @Override
    public void onDestroy() {
        Injector.getInstance().clearLaunchComponent();
        interactor.dispose();
        super.onDestroy();
    }
}

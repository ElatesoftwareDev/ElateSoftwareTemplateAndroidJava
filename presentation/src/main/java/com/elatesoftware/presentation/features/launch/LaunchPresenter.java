package com.elatesoftware.presentation.features.launch;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.elatesoftware.domain.interactors.LaunchInteractor;
import com.elatesoftware.presentation.features.auth.mail.AuthByEmailActivity;
import com.elatesoftware.presentation.features.main.MainActivity;

import javax.inject.Inject;

@InjectViewState
public class LaunchPresenter extends MvpPresenter<LaunchView> {

    private final LaunchInteractor interactor;
    private final Context context;

    @Inject
    LaunchPresenter(LaunchInteractor interactor, Context context) {
        this.interactor = interactor;
        this.context = context;
    }

    @Override
    public void attachView(LaunchView view) {
        super.attachView(view);
        showNextActivity();
    }

    @Override
    public void onDestroy() {
        interactor.dispose();
        super.onDestroy();
    }


    private void showNextActivity() {
        if (interactor.isAuth()) {
            getViewState().startNextActivity(MainActivity.getActivityIntent(context));
        } else {
            getViewState().startNextActivity(AuthByEmailActivity.getActivityIntent(context));
        }
    }
}

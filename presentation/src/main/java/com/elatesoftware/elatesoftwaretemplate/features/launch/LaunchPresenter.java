package com.elatesoftware.elatesoftwaretemplate.features.launch;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.elatesoftware.domain.interactors.LaunchInteractor;
import com.elatesoftware.elatesoftwaretemplate.di.Injector;
import com.elatesoftware.elatesoftwaretemplate.di.scopeannotations.PerActivity;
import com.elatesoftware.elatesoftwaretemplate.features.authemail.AuthByEmailActivity;

import javax.inject.Inject;

/**
 * Created by Андрей Евтухов on 11.04.2018.
 */

@PerActivity(LaunchActivity.class)
@InjectViewState
public class LaunchPresenter extends MvpPresenter<LaunchView> {

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

        } else {
            getViewState().startNextActivity(AuthByEmailActivity.getActivityIntent(context));
        }
    }

    @Override
    public void onDestroy() {
        Injector.getInstance().clearLaunchComponent();
        super.onDestroy();
    }
}

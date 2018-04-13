package com.elatesoftware.presentation.features.launch;

import com.arellomobile.mvp.InjectViewState;
import com.elatesoftware.domain.interactors.LaunchInteractor;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;
import com.elatesoftware.presentation.features.auth.mail.AuthByEmailActivity;
import com.elatesoftware.presentation.features.base.BasePresenter;
import com.elatesoftware.presentation.features.main.MainActivity;

import javax.inject.Inject;

@PerActivity(LaunchActivity.class)
@InjectViewState
public class LaunchPresenter extends BasePresenter<LaunchView> {

    final LaunchInteractor interactor;

    @Inject
    LaunchPresenter(LaunchInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(LaunchView view) {
        super.attachView(view);
        showNextActivity();
    }

    private void showNextActivity() {
        if (interactor.isAuth()) {
            getViewState().startNextActivity(MainActivity.getActivityIntent(context));
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

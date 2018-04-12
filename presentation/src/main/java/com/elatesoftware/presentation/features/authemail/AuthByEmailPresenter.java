package com.elatesoftware.presentation.features.authemail;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.elatesoftware.domain.interactors.AuthorizationInteractor;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

@PerActivity(AuthByEmailActivity.class)
@InjectViewState
public class AuthByEmailPresenter extends MvpPresenter<AuthByEmailView> {

    private final AuthorizationInteractor interactor;
    private final Context context;

    @Inject
    AuthByEmailPresenter(AuthorizationInteractor interactor, Context context) {
        this.interactor = interactor;
        this.context = context;
    }

    void login(String email, String password) {
        if (validateFields(email, password)) {
            interactor.login(email, password, new DisposableCompletableObserver() {
                @Override
                public void onComplete() {
                    onSuccessLogin();
                }

                @Override
                public void onError(Throwable e) {
                    onErrorLogin();
                }
            });
        }
    }

    private boolean validateFields(String email, String password) {
        return true;
    }

    private void onErrorLogin() {
        getViewState().showToast("Неуспешный неуспех");
    }

    private void onSuccessLogin() {
        getViewState().showToast("Успешный успех");
    }

    @Override
    public void onDestroy() {
        Injector.getInstance().clearAuthByEmailComponent();
        interactor.dispose();
        super.onDestroy();
    }
}

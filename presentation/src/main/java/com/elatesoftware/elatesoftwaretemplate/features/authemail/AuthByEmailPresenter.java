package com.elatesoftware.elatesoftwaretemplate.features.authemail;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.elatesoftware.domain.interactors.AuthorizationInteractor;
import com.elatesoftware.elatesoftwaretemplate.di.Injector;
import com.elatesoftware.elatesoftwaretemplate.di.scopeannotations.PerActivity;

import javax.inject.Inject;

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
            interactor.login(email, password).subscribe(this::onSuccessLogin,
                    throwable -> onErrorLogin());
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
        super.onDestroy();
    }
}

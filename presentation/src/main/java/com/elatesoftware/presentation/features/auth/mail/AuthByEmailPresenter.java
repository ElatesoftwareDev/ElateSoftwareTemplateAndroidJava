package com.elatesoftware.presentation.features.auth.mail;

import com.arellomobile.mvp.InjectViewState;
import com.elatesoftware.domain.interactors.AuthorizationInteractor;
import com.elatesoftware.presentation.di.Injector;
import com.elatesoftware.presentation.di.scopeannotations.PerActivity;
import com.elatesoftware.presentation.features.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

@PerActivity(AuthByEmailActivity.class)
@InjectViewState
public class AuthByEmailPresenter extends BasePresenter<AuthByEmailView> {

    final AuthorizationInteractor interactor;

    @Inject
    AuthByEmailPresenter(AuthorizationInteractor interactor) {
        this.interactor = interactor;
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
                    handleError(e);
                }
            });
        }
    }

    private boolean validateFields(String email, String password) {
        return true;
    }

    private void onSuccessLogin() {
        getViewState().showToast("Success");
    }

    @Override
    public void onDestroy() {
        Injector.getInstance().clearAuthByEmailComponent();
        interactor.dispose();
        super.onDestroy();
    }
}

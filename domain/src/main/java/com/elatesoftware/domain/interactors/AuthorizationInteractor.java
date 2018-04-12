package com.elatesoftware.domain.interactors;

import com.elatesoftware.domain.interactors.base.BaseInteractor;
import com.elatesoftware.domain.usecases.AuthorizationUseCase;

import javax.inject.Inject;

import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class AuthorizationInteractor extends BaseInteractor {

    private final AuthorizationUseCase authorizationUseCase;

    @Inject
    AuthorizationInteractor(AuthorizationUseCase authorizationUseCase) {
        this.authorizationUseCase = authorizationUseCase;
    }

    public void login(String email, String password, DisposableCompletableObserver observer) {
        execute(authorizationUseCase, new AuthorizationUseCase.AuthorizationData(email, password), observer);
    }

}

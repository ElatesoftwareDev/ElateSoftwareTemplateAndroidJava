package com.elatesoftware.domain.interactors;

import com.elatesoftware.domain.usecases.AuthorizationUseCase;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class AuthorizationInteractor {

    private final AuthorizationUseCase authorizationUseCase;

    @Inject
    AuthorizationInteractor(AuthorizationUseCase authorizationUseCase) {
        this.authorizationUseCase = authorizationUseCase;
    }

    public Completable login(String email, String password){
        return authorizationUseCase.login(email, password);
    }

}

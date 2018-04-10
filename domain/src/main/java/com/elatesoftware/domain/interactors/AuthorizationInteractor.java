package com.elatesoftware.domain.interactors;

import com.elatesoftware.domain.usecases.AuthorizationUseCase;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class AuthorizationInteractor {

    private final AuthorizationUseCase authorizationUseCase;

    public AuthorizationInteractor(AuthorizationUseCase authorizationUseCase) {
        this.authorizationUseCase = authorizationUseCase;
    }

    public Observable<String> login(String email, String password){
        return authorizationUseCase.login(email, password);
    }

}

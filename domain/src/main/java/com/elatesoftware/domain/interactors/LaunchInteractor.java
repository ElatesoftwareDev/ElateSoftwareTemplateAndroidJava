package com.elatesoftware.domain.interactors;

import com.elatesoftware.domain.usecases.IsAuthUseCase;

import javax.inject.Inject;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class LaunchInteractor {

    private final IsAuthUseCase isAuthUseCase;

    @Inject
    LaunchInteractor(IsAuthUseCase isAuthUseCase) {
        this.isAuthUseCase = isAuthUseCase;
    }

    public boolean isAuth(){
        return isAuthUseCase.isAuth();
    }

}

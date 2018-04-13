package com.elatesoftware.domain.interactors;

import com.elatesoftware.domain.interactors.base.BaseInteractor;
import com.elatesoftware.domain.usecases.IsAuthUseCase;

import javax.inject.Inject;


public class LaunchInteractor extends BaseInteractor {

    private final IsAuthUseCase isAuthUseCase;

    @Inject
    LaunchInteractor(IsAuthUseCase isAuthUseCase) {
        this.isAuthUseCase = isAuthUseCase;
    }

    public boolean isAuth() {
        return isAuthUseCase.execute();
    }

}

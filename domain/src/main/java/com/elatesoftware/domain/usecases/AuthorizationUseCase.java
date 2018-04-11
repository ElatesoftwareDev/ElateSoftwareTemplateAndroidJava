package com.elatesoftware.domain.usecases;

import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class AuthorizationUseCase {

    private final IRepository repository;

    @Inject
    AuthorizationUseCase(IRepository repository) {
        this.repository = repository;
    }

    public Completable login(String email, String password){
        return repository.login(email, password);
    }
}

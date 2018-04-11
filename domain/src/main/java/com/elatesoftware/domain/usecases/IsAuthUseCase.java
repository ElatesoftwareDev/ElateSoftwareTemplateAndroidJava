package com.elatesoftware.domain.usecases;

import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Inject;

public class IsAuthUseCase {

    private final IRepository repository;

    @Inject
    IsAuthUseCase(IRepository repository) {
        this.repository = repository;
    }

    public boolean isAuth() {
        return repository.isAuth();
    }
}

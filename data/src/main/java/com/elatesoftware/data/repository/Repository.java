package com.elatesoftware.data.repository;

import com.elatesoftware.data.local.Cache;
import com.elatesoftware.data.network.api.RestApiService;
import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public class Repository implements IRepository {

    private final RestApiService networkRepository;
    private final Cache cache;

    @Inject
    Repository(RestApiService networkRepository, Cache cache) {
        this.networkRepository = networkRepository;
        this.cache = cache;
    }

    @Override
    public Completable login(final String email, final String password) {
        return networkRepository
                .login(email, password)
               // .doOnSuccess(cache::setToken)
                .toCompletable();
    }

    @Override
    public boolean isAuth() {
        return true;
    }
}

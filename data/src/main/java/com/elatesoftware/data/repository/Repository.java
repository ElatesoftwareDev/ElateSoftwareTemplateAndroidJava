package com.elatesoftware.data.repository;

import com.elatesoftware.data.local.Cache;
import com.elatesoftware.data.network.api.RestApiService;
import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;

@Singleton
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
                .toCompletable();
    }

    @Override
    public boolean isAuth() {
        return true;// cache.getToken() != null;
    }
}

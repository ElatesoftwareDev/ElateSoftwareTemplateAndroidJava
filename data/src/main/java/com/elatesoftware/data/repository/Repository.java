package com.elatesoftware.data.repository;

import com.elatesoftware.data.network.api.RestApiService;
import com.elatesoftware.domain.repository.IRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public class Repository implements IRepository {

    private final RestApiService networkRepository;
   // private final LocalRepository localRepository;

    @Inject
    public Repository(RestApiService networkRepository) {
        this.networkRepository = networkRepository;
    //    this.localRepository = localRepository;
    }

    @Override
    public Observable<String> login(String email, String password) {
        return networkRepository.login(email, password);
    }
}

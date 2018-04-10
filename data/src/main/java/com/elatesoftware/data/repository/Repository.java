package com.elatesoftware.data.repository;

import com.elatesoftware.data.local.LocalRepository;
import com.elatesoftware.data.network.NetworkRepository;
import com.elatesoftware.domain.repository.IRepository;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public class Repository implements IRepository {

    private final NetworkRepository networkRepository;
    private final LocalRepository localRepository;

    public Repository(NetworkRepository networkRepository, LocalRepository localRepository) {
        this.networkRepository = networkRepository;
        this.localRepository = localRepository;
    }

    @Override
    public Observable<String> login(String email, String password) {
        return networkRepository.login(email, password);
    }
}

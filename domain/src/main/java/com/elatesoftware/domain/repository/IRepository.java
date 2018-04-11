package com.elatesoftware.domain.repository;

import io.reactivex.Completable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public interface IRepository {

    Completable login(String email, String password);

    boolean isAuth();

}

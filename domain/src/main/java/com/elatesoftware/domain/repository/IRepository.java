package com.elatesoftware.domain.repository;

import io.reactivex.Completable;


public interface IRepository {

    Completable login(String email, String password);

    boolean isAuth();

}

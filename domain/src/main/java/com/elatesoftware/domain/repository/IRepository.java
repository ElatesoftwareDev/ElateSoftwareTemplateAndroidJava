package com.elatesoftware.domain.repository;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public interface IRepository {

    Observable<String> login(String email, String password);

}

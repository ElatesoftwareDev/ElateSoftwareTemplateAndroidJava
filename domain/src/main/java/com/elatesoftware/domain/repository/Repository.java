package com.elatesoftware.domain.repository;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public interface Repository {

    Observable<String> login(String email, String password);

}

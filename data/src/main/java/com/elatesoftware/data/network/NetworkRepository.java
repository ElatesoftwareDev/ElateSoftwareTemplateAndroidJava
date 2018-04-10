package com.elatesoftware.data.network;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 10.04.2018.
 */

public interface NetworkRepository {

    Observable<String> login(String email, String password);

}

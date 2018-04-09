package com.elatesoftware.data.api;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class ApiService {

    private final Api api;

    ApiService(Api restApi) {
        this.api = restApi;
    }

    public Observable<String> login(String email, String password){
        return api.login(email, password);
    }
}

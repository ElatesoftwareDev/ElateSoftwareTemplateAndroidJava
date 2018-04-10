package com.elatesoftware.data.network.api;

import com.elatesoftware.data.network.NetworkRepository;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class RestApiService implements NetworkRepository{

    private final RestApi restApi;

    RestApiService(RestApi restRestApi) {
        this.restApi = restRestApi;
    }

    public Observable<String> login(String email, String password){
        return restApi.login(email, password);
    }
}

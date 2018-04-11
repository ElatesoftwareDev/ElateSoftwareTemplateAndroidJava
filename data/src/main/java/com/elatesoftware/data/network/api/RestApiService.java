package com.elatesoftware.data.network.api;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class RestApiService{

    private final RestApi restApi;

    @Inject
    public RestApiService(RestApi restRestApi) {
        this.restApi = restRestApi;
    }

    public Observable<String> login(String email, String password){
        return restApi.login(email, password);
    }
}

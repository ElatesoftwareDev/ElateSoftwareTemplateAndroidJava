package com.elatesoftware.data.network.api;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class RestApiService{

    private final RestApi restApi;

    @Inject
    RestApiService(RestApi restRestApi) {
        this.restApi = restRestApi;
    }

    public Single<String> login(String email, String password){
        String mockToken = "dhsjkagk13y89gfkdgshfghdjsk6ty7ghjdfsgjgh";
        return Single.just(mockToken);
    }
}
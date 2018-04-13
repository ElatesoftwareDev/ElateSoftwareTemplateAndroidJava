package com.elatesoftware.data.network.api;

import com.elatesoftware.data.local.Cache;
import com.elatesoftware.domain.entities.LoginBody;
import com.elatesoftware.domain.entities.UserResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;


public class RestApiService{

    private final RestApi restApi;

    private final Cache cache;

    @Inject
    RestApiService(RestApi restRestApi, Cache cache) {
        this.restApi = restRestApi;
        this.cache = cache;
    }

    public Single<Response<UserResponse>> login(String email, String password){
        //String mockToken = "dhsjkagk13y89gfkdgshfghdjsk6ty7ghjdfsgjgh";
        return restApi.logIn(new LoginBody(email, password));
        // .doOnSuccess(cache::setToken);
    }
}
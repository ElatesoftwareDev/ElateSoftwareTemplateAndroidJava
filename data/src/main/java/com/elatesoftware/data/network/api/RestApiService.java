package com.elatesoftware.data.network.api;

import com.elatesoftware.domain.models.LoginBody;
import com.elatesoftware.domain.models.UserResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public class RestApiService{

    private final RestApi restApi;

    @Inject
    RestApiService(RestApi restRestApi) {
        this.restApi = restRestApi;
    }

    public Single<Response<UserResponse>> login(String email, String password){
        //String mockToken = "dhsjkagk13y89gfkdgshfghdjsk6ty7ghjdfsgjgh";
        return restApi.logIn(new LoginBody(email, password));
    }
}
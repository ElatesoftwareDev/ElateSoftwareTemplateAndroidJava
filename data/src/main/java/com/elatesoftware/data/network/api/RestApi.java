package com.elatesoftware.data.network.api;

import com.elatesoftware.domain.entities.LoginBody;
import com.elatesoftware.domain.entities.UserResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {

    //возвращает типа токен
    @POST("api/account/login")
    Observable<String> login(@Query("email") String email, @Query("password") String password);

    @POST("api/account/login")
    Single<Response<UserResponse>> logIn(@Body LoginBody loginBody);

}

package com.elatesoftware.data.network.api;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public interface RestApi {

    //возвращает типа токен
    @GET("login")
    Observable<String> login(@Query("email") String email, @Query("password") String password);

}

package com.elatesoftware.data.api;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Андрей Евтухов on 09.04.2018.
 */

public interface Api {

    @GET("login")
    Observable<String> login(@Query("email") String email, @Query("password") String password);

}

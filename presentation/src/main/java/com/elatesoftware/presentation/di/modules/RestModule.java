package com.elatesoftware.presentation.di.modules;


import android.content.Context;

import com.elatesoftware.data.errorshandling.ErrorHandlingInterceptor;
import com.elatesoftware.data.network.api.RestApi;
import com.elatesoftware.presentation.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public interface RestModule {

    @Provides
    @Singleton
    static RestApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("http://mytasks.elatesof.w07.hoster.by/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor logging,
                                            ErrorHandlingInterceptor errorHandlingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(errorHandlingInterceptor)
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor provideLogging() {
        return new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ?
                HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
    }

    @Provides
    @Singleton
    static ErrorHandlingInterceptor provideErrorInterceptor(Context context) {
        return new ErrorHandlingInterceptor(context);
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}

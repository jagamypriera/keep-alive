package io.skipday.keepalive.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.skipday.keepalive.api.API;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by jagamypriera on 03/04/16.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    HttpUrl provideHttpUrl() {
        return HttpUrl.parse("http://eoffice.hexaglobal.co.id");
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(HttpUrl httpUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    API provideApiService(Retrofit retrofit) {
        return retrofit.create(API.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(loggingInterceptor);
        return client;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .create();
    }
}

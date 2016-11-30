package io.skipday.keepalive.presenters;


import android.util.Log;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import javax.inject.Inject;

import io.skipday.keepalive.api.API;
import io.skipday.keepalive.dagger.App;
import io.skipday.keepalive.models.BaseResponse;
import io.skipday.keepalive.mvp.MainMvp;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainPresenter implements BasePresenter<MainMvp.PingMvp> {
    @Inject
    API api;
    private MainMvp.PingMvp mvp;

    public MainPresenter() {
        App.appComponent().inject(this);
    }

    @Override
    public void attachView(MainMvp.PingMvp view) {
        this.mvp = view;
    }

    @Override
    public void detachView() {
        this.mvp = null;
    }

    public void ping(String url) {
        api.ping(url).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    mvp.onSuccess(response.body().string());
                } catch (IOException e) {
                    mvp.onFailed(e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                mvp.onFailed(t.getMessage());
            }
        });
    }
    public void get(String url) {
        api.get(url).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Response<BaseResponse> response, Retrofit retrofit) {
                Log.e("asdff",response.body().toString());
                mvp.onSuccess(response.body().getMessage());
            }

            @Override
            public void onFailure(Throwable t) {
                mvp.onFailed(t.getMessage());
                Log.e("asdff",t.getMessage());
            }
        });
    }
}


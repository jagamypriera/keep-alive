package io.skipday.keepalive.api;

import com.squareup.okhttp.ResponseBody;

import io.skipday.keepalive.models.BaseResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Streaming;
import retrofit.http.Url;

/**
 * Created by jagamypriera on 02/04/16.
 */
public interface API {
    @GET
    Call<ResponseBody> ping(@Url String url);
    @Headers({"Connection: keep-alive","Accept-Encoding: gzip, deflate, sdch"})
    @GET
    Call<BaseResponse> get(@Url String url);
}

package io.skipday.keepalive.mvp;

/**
 * Created by jagamypriera on 10/06/16.
 */
public interface MainMvp {
    interface PingMvp{
        void onSuccess(String response);
        void onFailed(String message);
    }
}

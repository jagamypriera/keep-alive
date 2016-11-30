package io.skipday.keepalive.presenters;

/**
 * Created by jagamypriera on 03/04/16.
 */
interface BasePresenter<V> {
    void attachView(V view);

    void detachView();
}

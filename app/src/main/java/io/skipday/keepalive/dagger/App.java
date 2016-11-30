package io.skipday.keepalive.dagger;

import android.app.Application;

import io.skipday.keepalive.dagger.modules.AppModule;
import io.skipday.keepalive.dagger.modules.NetworkModule;

/**
 * Created by jagamypriera on 03/04/16.
 */
public class App extends Application {
    private static AppComponent appComponent;

    public static AppComponent appComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .networkModule(new NetworkModule()).build();
        appComponent.inject(this);
    }
}

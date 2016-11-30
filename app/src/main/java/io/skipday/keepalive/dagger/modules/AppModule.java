package io.skipday.keepalive.dagger.modules;

import android.app.Application;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.skipday.keepalive.dagger.App;

/**
 * Created by jagamypriera on 03/04/16.
 */
@Module
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }
}

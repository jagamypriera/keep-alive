package io.skipday.keepalive.dagger;


import javax.inject.Singleton;

import dagger.Component;
import io.skipday.keepalive.dagger.modules.AppModule;
import io.skipday.keepalive.dagger.modules.NetworkModule;
import io.skipday.keepalive.presenters.MainPresenter;

/**
 * Created by jagamypriera on 03/04/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(App app);
    void inject(MainPresenter presenter);
}

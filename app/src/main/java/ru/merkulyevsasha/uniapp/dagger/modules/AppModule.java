package ru.merkulyevsasha.uniapp.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import ru.merkulyevsasha.uniapp.presentation.MainActivity;
import ru.merkulyevsasha.uniapp.dagger.scopes.MainActivityScope;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

@Module(includes = {AndroidSupportInjectionModule.class},
        subcomponents = {})
public abstract class AppModule {

    @Singleton
    @Provides
    static Scheduler providesScheduler() {
        return Schedulers.io();
    }

    @MainActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainInjector();

//    @LoginActivityScope
//    @ContributesAndroidInjector(modules = LoginModule.class)
//    abstract LoginActivity loginInjector();
//
//    @SplashActivityScope
//    @ContributesAndroidInjector(modules = SplashActivityModule.class)
//    abstract SplashActivity splashIngector();

}

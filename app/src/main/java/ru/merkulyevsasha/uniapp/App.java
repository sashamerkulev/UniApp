package ru.merkulyevsasha.uniapp;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ru.merkulyevsasha.uniapp.dagger.components.AppComponent;
import ru.merkulyevsasha.uniapp.dagger.components.DaggerAppComponent;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

public class App extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent component = DaggerAppComponent
                .builder()
                .context(this)
                .build();
        component.inject(this);

//        if (BuildConfig.DEBUG_MODE) {
//            if (LeakCanary.isInAnalyzerProcess(this)) {
//                // This process is dedicated to LeakCanary for heap analysis.
//                // You should not init your app in this process.
//                return;
//            }
//            LeakCanary.install(this);
//        }

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }}

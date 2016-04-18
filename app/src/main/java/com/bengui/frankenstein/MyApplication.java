package com.bengui.frankenstein;

import android.app.Application;

/**
 * @author benjamin.massello.
 */
public class MyApplication extends Application {


    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                                         .appModule(new AppModule(this))
                                         .build();

        FrankensteinActivityLifecycleCallbacks frankensteinActivityLifecycleCallbacks = appComponent.getFrankensteinActivityLifecycleCallbacks();
        registerActivityLifecycleCallbacks(frankensteinActivityLifecycleCallbacks);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}

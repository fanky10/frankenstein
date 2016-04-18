/* (c) Disney. All rights reserved. */
package com.bengui.volleytest;

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
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}

/* (c) Disney. All rights reserved. */
package com.bengui.volleytest;

import android.content.Context;
import android.util.Log;

import com.bengui.volleytest.managers.VolleyManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author benjamin.massello.
 */
@Module
public class AppModule {

    private final Context context;

    AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    VolleyManager provideVolleyManager(Context context) {
        return new VolleyManager(context);
    }

}

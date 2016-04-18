package com.bengui.frankenstein;

import android.content.Context;

import com.bengui.frankenstein.managers.VolleyManager;

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

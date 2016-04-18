package com.bengui.volleytest;

import com.bengui.volleytest.fragments.UserFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author benjamin.massello.
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(UserFragment userFragment);
}

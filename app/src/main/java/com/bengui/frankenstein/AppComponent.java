package com.bengui.frankenstein;

import com.bengui.frankenstein.fragments.UserFragment;

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

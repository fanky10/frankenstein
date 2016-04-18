package com.bengui.frankenstein;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;

import javax.inject.Inject;

/**
 * @author benjamin.massello.
 */
public class FrankensteinActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    @Inject
    public FrankensteinActivityLifecycleCallbacks() {

    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        AccessibilityManager accessibilityManager = (AccessibilityManager) activity.getSystemService(Context.ACCESSIBILITY_SERVICE);
        boolean touchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        Log.d("bengui", "bengui onActivityCreated - touch exploration enabled: " + touchExplorationEnabled);
        accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManager.TouchExplorationStateChangeListener() {
            @Override
            public void onTouchExplorationStateChanged(boolean enabled) {
                Log.d("bengui", "bengui onTouchExplorationStateChanged - touch exploration enabled: " + enabled);
            }
        });
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}

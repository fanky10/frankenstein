package com.bengui.frankenstein.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bengui.frankenstein.fragments.ImageScreenFragment;
import com.bengui.frankenstein.fragments.MainMenuFragment;
import com.bengui.frankenstein.R;
import com.bengui.frankenstein.fragments.RecyclerListFragment;
import com.bengui.frankenstein.fragments.UserGsonReqFragment;
import com.bengui.frankenstein.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity implements MainMenuFragment.MainMenuNavigation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Loads the Main Menu Fragment
        //we should not add this fragment to the back stack because it's the top fragment in the Activity.
        MainMenuFragment userFragment = new MainMenuFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, userFragment)
                .commit();
    }


    @Override
    public void navigateToUserData() {
        UserGsonReqFragment userFragment = new UserGsonReqFragment();
        navigateTo(userFragment);
    }

    @Override
    public void navigateToUserList() {
        UserListFragment userListFragment = new UserListFragment();
        navigateTo(userListFragment);
    }

    @Override
    public void navigateToImageScreen() {
        ImageScreenFragment imageScreenFragment = new ImageScreenFragment();
        navigateTo(imageScreenFragment);
    }

    @Override
    public void navigateToRecyclerList() {
        RecyclerListFragment recyclerListFragment = new RecyclerListFragment();
        navigateTo(recyclerListFragment);
    }

    /**
     * Navigates to the given fragment.
     * @param fragment
     */
    private void navigateTo(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}

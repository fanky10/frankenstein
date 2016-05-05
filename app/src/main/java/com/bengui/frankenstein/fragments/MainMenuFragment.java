package com.bengui.frankenstein.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bengui.frankenstein.R;

/**
 * @author benjamin.massello.
 */
public class MainMenuFragment extends Fragment {


    private MainMenuNavigation mainMenuNavigation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainMenuNavigation = (MainMenuNavigation) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_main_menu, null);

        View.OnClickListener listenner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.user_data_btn) {

                }
            }
        };

        view.findViewById(R.id.user_data_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuNavigation.navigateToUserData();
            }
        });

        view.findViewById(R.id.user_list_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuNavigation.navigateToUserList();
            }
        });

        view.findViewById(R.id.image_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuNavigation.navigateToImageScreen();
            }
        });

        view.findViewById(R.id.recycle_list_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuNavigation.navigateToRecyclerList();
            }
        });

        return view;
    }

    public interface MainMenuNavigation {

        void navigateToUserData();

        void navigateToUserList();

        void navigateToImageScreen();

        void navigateToRecyclerList();

    }

}

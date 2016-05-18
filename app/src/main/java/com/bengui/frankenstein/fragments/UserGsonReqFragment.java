package com.bengui.frankenstein.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bengui.frankenstein.R;
import com.bengui.frankenstein.managers.GsonRequest;
import com.bengui.frankenstein.managers.VolleyManager;
import com.bengui.frankenstein.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author benjamin.massello.
 */
public class UserGsonReqFragment extends Fragment {
    public static final String BASE_URL = "https://raw.githubusercontent.com/bengui/volleytest/master/json/user.json";
    public static final String TAG = UserFragment.class.getSimpleName();

    private VolleyManager volleyManager;

    //Views
    @BindView(R.id.request_btn) Button requestButton;
    @BindView(R.id.clean_btn) Button cleanButton;
    @BindView(R.id.user_name) TextView userNameTextView;
    @BindView(R.id.user_last_name) private TextView userLastNameTextView;
    @BindView(R.id.user_age) private TextView userAgeTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        ButterKnife.bind(this, view);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserData();
            }
        });

        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameTextView.setText("");
                userLastNameTextView.setText("");
                userAgeTextView.setText("");
            }
        });

        return view;
    }


    private void getUserData() {
        requestButton.setEnabled(false);
        GsonRequest<User> request = new GsonRequest<>(
                BASE_URL,
                User.class,
                null,
                new Response.Listener<User>() {
                    @Override
                    public void onResponse(User user) {
                        userNameTextView.setText(user.getName());
                        userLastNameTextView.setText(user.getLastName());
                        userAgeTextView.setText(String.valueOf(user.getAge()));
                        requestButton.setEnabled(true);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());
                        requestButton.setEnabled(true);
                    }
                });

        volleyManager = VolleyManager.getInstance(getActivity().getApplicationContext());
        volleyManager.addToRequestQueue(request);
    }

}

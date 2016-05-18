package com.bengui.frankenstein.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bengui.frankenstein.R;
import com.bengui.frankenstein.adapters.MyRecyclerAdapter;

/**
 * @author benjamin.massello.
 */
public class RecyclerListFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private String[] dataSet = new String[30];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataSet();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_list, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(dataSet);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initDataSet() {
        for (int i = 0; i < dataSet.length; i++) {
            dataSet[i] = "element " + i;
        }
    }
}

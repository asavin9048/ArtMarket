package com.example.krist.artmarket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import RecyclesAdapters.BrendsRecycler;

/**
 * Created by Krist on 16.10.2017.
 */

public class Brends extends Fragment
{

    String categName;

    public Brends(String categName){
        this.categName=categName;
    }
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    public Brends() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new BrendsRecycler(getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }
}



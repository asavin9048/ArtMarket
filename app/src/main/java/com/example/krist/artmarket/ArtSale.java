package com.example.krist.artmarket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import RecyclesAdapters.Recycler_ArtSale;

/**
 * Created by Krist on 16.10.2017.
 */

public class ArtSale extends Fragment
{

    String categName;

    public ArtSale(String categName){
        this.categName=categName;
    }
    RecyclerView recyclerView;
    // RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;

    public ArtSale() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_art_sale1, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_artsale);


        lLayout = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new Recycler_ArtSale();
        recyclerView.setAdapter(adapter);
        return view;
    }
}



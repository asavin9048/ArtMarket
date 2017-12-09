package com.example.krist.artmarket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import asavin.mvp.view.adapters.BasketAdapter;
//import ua.com.prologistic.navigationdrawerproject.R;

public class BasketFull extends Fragment
{

    public BasketFull() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basket_full, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.basket_recycler_view);


        recyclerView.setHasFixedSize(true);
        GridLayoutManager lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        BasketAdapter adapter = new BasketAdapter(getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
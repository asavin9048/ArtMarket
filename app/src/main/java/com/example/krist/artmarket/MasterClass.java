package com.example.krist.artmarket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import RecyclesAdapters.RecyclerAdapterMasterClass;


public class MasterClass extends Fragment {
    String categName;

    public MasterClass(String categName){
        this.categName=categName;
         }
    RecyclerView recyclerView;
   // RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;

    public MasterClass() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_master_class, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_master_cl);

        //layoutManager = new LinearLayoutManager(getContext());
        lLayout = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new RecyclerAdapterMasterClass(getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }
}



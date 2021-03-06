package ClassesChild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.R;

import RecyclesAdapters.Child_Recycler_Pazli;

//package MenuFragments;


public class Pazli extends Fragment {

    RecyclerView recyclerView;
    private GridLayoutManager lLayout;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    public Pazli() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_child_pazli, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_pazli);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Child_Recycler_Pazli(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}






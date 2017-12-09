package ClassesChild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.R;

import RecyclesAdapters.Child_Recycler_Flomast;

//package MenuFragments;


public class Flomast extends Fragment {

    RecyclerView recyclerView;
    private GridLayoutManager lLayout;
    RecyclerView.Adapter adapter;


    public Flomast() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_child_flomast, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_flomast);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new Child_Recycler_Flomast(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}






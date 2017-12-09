package ClassesHobbie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.R;

import RecyclesAdapters.HobbieRecycler_Decorir;

//package MenuFragments;


public class Decorirov extends Fragment {

    RecyclerView recyclerView;
    private GridLayoutManager lLayout;
    RecyclerView.Adapter adapter;


    public Decorirov() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_hobbie_decorir, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_decorir);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new HobbieRecycler_Decorir(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}






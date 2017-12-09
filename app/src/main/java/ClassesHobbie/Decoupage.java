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

import RecyclesAdapters.HobbieRecycler_Decoupage;

//package MenuFragments;


public class Decoupage extends Fragment {

    RecyclerView recyclerView;
    private GridLayoutManager lLayout;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public Decoupage() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_hobbie_decoupage, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_decoupage);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new HobbieRecycler_Decoupage(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}






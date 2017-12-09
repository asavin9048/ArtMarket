package ClassesZhivopis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.R;

import RecyclesAdapters.RecyclerKraski;

//package MenuFragments;


public class Kraski extends Fragment {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;

    public Kraski() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_zhivopis_kraski, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_kraski);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new RecyclerKraski(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}



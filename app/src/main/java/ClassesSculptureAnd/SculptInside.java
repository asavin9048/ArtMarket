package ClassesSculptureAnd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.R;

import RecyclesAdapters.SculptAnd_Recycler_Sculpture;


public class SculptInside extends Fragment {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;

    public SculptInside() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_sculpture1, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_sculpt1);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new SculptAnd_Recycler_Sculpture(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}









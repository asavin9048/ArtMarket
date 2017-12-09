package MenuFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.R;

import RecyclesAdapters.RecyclerAdapterCreativitySet;


public class CreativitySet extends Fragment {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;

    public CreativitySet() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_menu_artset, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_artset);

        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new RecyclerAdapterCreativitySet();
        recyclerView.setAdapter(adapter);
        return view;
    }




}




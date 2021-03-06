package ClassesHobbie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.R;

import RecyclesAdapters.HobbieRecycler_Valyanie;

//package MenuFragments;


public class Valyanie extends Fragment {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public Valyanie() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_hobbie_valyanie, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_valyanie);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new HobbieRecycler_Valyanie(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}






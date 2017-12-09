package MenuFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.krist.artmarket.R;
import com.example.krist.artmarket.RecyclerViewClickListener;

import ClassesSculptureAnd.Resba;
import ClassesSculptureAnd.SculptInside;
import RecyclesAdapters.RecyclerAdapterSculpt;


public class Sculpture extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public Sculpture() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_menu_sculpture, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_sculpt);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                switch (position){
                    case 0:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new SculptInside(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }

                    case 1:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Resba(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }

                    default: Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();

                }


            }
        };

        RecyclerAdapterSculpt adapter = new RecyclerAdapterSculpt(listener);
        recyclerView.setAdapter(adapter);
        return v;
    }}





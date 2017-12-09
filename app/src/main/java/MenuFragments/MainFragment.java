package MenuFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.artmarket.ArtSale;
import com.example.krist.artmarket.Brends;
import com.example.krist.artmarket.MasterClass;
import com.example.krist.artmarket.R;
import com.example.krist.artmarket.RecyclerViewClickListener;

import RecyclesAdapters.RecyclerAdapterMain;


public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public MainFragment() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_main, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_main);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

switch (position){


    case 0:{
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new MasterClass("Мастер-класс"),"findThisFragment")
                .addToBackStack(null)
                .commit();
        break;
    }
    case 1:{
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new ArtSale(),"findThisFragment")
                .addToBackStack(null)
                .commit();
        break;
    }
    case 2:{
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new Brends(),"findThisFragment")
                .addToBackStack(null)
                .commit();
        break;
    }


}


            }
        };

        RecyclerAdapterMain adapter = new RecyclerAdapterMain(listener);
        recyclerView.setAdapter(adapter);
        return v;
    }




}






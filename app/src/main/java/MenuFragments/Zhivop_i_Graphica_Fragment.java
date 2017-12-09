package MenuFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.krist.artmarket.R;
import com.example.krist.artmarket.RecyclerViewClickListener;

import RecyclesAdapters.RecyclerAdapterZhivop;
import ClassesZhivopis.Bumaga;
import ClassesZhivopis.Holsti;
import ClassesZhivopis.Karandash;
import ClassesZhivopis.Kisti;
import ClassesZhivopis.Kraski;
import ClassesZhivopis.Molberts;


public class Zhivop_i_Graphica_Fragment extends Fragment {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;

    public Zhivop_i_Graphica_Fragment() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_menu_zhiv_graph, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_zhivopis);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                switch (position){
                    case 0:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Holsti(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 1:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Kraski(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 2:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Karandash(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 3:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Bumaga(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }

                    case 4:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Kisti(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 5:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Molberts(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                   default: Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();

                }


            }
        };

        RecyclerAdapterZhivop adapter = new RecyclerAdapterZhivop(listener);
        recyclerView.setAdapter(adapter);
        return v;

}
}






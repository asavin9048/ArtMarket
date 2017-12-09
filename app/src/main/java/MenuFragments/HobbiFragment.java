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

import ClassesHobbie.Decorirov;
import ClassesHobbie.Decoupage;
import ClassesHobbie.Kvilling;
import ClassesHobbie.Valyanie;
import ClassesHobbie.Vizhiganie;
import ClassesHobbie.Zolochenie;
import RecyclesAdapters.RecyclerAdapterHobbie;


public class HobbiFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;


    public HobbiFragment() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_menu_hobbie, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                switch (position){
                    case 0:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Valyanie(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 1:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Vizhiganie(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 2:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Decorirov(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 3:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Decoupage(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }

                    case 4:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Kvilling(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    case 5:{
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.content_frame, new Zolochenie(),"findThisFragment")
                                .addToBackStack(null)
                                .commit();
                        break;
                    }
                    default: Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();

                }


            }
        };

        RecyclerAdapterHobbie adapter = new RecyclerAdapterHobbie(listener);
        recyclerView.setAdapter(adapter);
        return v;
    }
   }

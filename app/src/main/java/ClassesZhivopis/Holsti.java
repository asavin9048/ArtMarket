package ClassesZhivopis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.krist.artmarket.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import RecyclesAdapters.RecyclerHolsti;
import asavin.mvp.App;
import asavin.mvp.model.entity.brand.Brand;
import asavin.mvp.model.entity.painting.Brush;
import asavin.mvp.view.views.MultiSelectionSpinner;

//package MenuFragments;


public class Holsti extends Fragment implements AdapterView.OnItemClickListener{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private GridLayoutManager lLayout;
    MultiSelectionSpinner spinner;
    public Holsti() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_zhivopis_holsti, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_holst);

        recyclerView.setHasFixedSize(true);
        lLayout = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lLayout);

        adapter = new RecyclerHolsti(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        for (Brand brand:spinner.getSelectedBrands()){
            Log.d("brand",brand.getName());
        }
    }
}



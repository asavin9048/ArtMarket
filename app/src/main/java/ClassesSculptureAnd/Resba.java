package ClassesSculptureAnd;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.krist.artmarket.R;
import RecyclesAdapters.SculptAnd_Recycler_Resba;


public class Resba extends Fragment {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager lLayout;
    public Resba() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_sculpture_resba, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_resba);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SculptAnd_Recycler_Resba(getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }
}









package RecyclesAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.MainActivity;
import com.example.krist.artmarket.R;

import java.util.List;

import asavin.mvp.App;
import asavin.mvp.model.dao.ColoringDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.PaintDao;
import asavin.mvp.model.dao.ToyDao;
import asavin.mvp.model.entity.child.Coloring;
import asavin.mvp.model.entity.child.Toy;
import asavin.mvp.model.entity.painting.Paint;
import asavin.mvp.view.fragments.DetailsFragment;

/**
 * Created by Krist on 11.11.2017.
 */


public class Child_Recycler_Raskraski extends RecyclerView.Adapter<Child_Recycler_Raskraski.ViewHolder> {
    ColoringDao coloringDao;
    List<Coloring> allColorings;

    Context context;

    public Child_Recycler_Raskraski (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        coloringDao = daoSession.getColoringDao();

        allColorings = coloringDao.loadAll();

    }
    //TODO использовать расукраски
    private int[] imagesRaskraski= {
            R.drawable.rakr_kontur,
            R.drawable.raskr_nomer,
            R.drawable.raskr_antistress,
            R.drawable.raskr_vod
    };



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageVal;
        public TextView itemTitleVal;


        public ViewHolder(View itemView) {
            super(itemView);
            itemImageVal = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleVal = (TextView)itemView.findViewById(R.id.item_title_child);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(context instanceof MainActivity){
                        Fragment f = new DetailsFragment();
                        Bundle b = new Bundle();
                        b.putLong("id",allColorings.get(position).getId());
                        b.putString("productName",allColorings.get(position).getClass().getSimpleName());


                        f.setArguments(b);


                        ((MainActivity)context).OpenFragment(f);
                    }
                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }
            });
        }
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolderVal = new ViewHolder(v);
        return viewHolderVal;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleVal.setText(allColorings.get(i).getName());
        holder.itemImageVal.setImageResource(context.getResources().getIdentifier
                (allColorings.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allColorings.size();
    }


}


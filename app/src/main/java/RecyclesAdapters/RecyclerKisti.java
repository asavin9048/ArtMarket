package RecyclesAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import asavin.mvp.model.dao.BrushDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.PencilDao;
import asavin.mvp.model.entity.painting.Brush;
import asavin.mvp.model.entity.painting.Pencil;
import asavin.mvp.view.fragments.DetailsFragment;

/**
 * Created by Krist on 11.11.2017.
 */


public class RecyclerKisti extends RecyclerView.Adapter<RecyclerKisti.ViewHolder> {


    BrushDao brushDao;
    List<Brush> allBrushes;
    Context context;
    public RecyclerKisti (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        brushDao = daoSession.getBrushDao();

        allBrushes = brushDao.loadAll();

    }

//    private String[] titlesKisti = {
//            "Из волоса пони",
//            "Из волоса щетины",
//            "Из волоса белки",
//            "Из волоса колонка",
//            "Синтетика",
//            "Мастихины"};

    private int[] imagesKisti = {
            R.drawable.kis_is_volosa_poni,
            R.drawable.kis_shetinu,
            R.drawable.kis_belki,
            R.drawable.kis_kolonok,
            R.drawable.kisti,
            R.drawable.kis_mastixini

    };



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageKisti;
        public TextView itemTitleKisti;
        //public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageKisti = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleKisti = (TextView)itemView.findViewById(R.id.item_title_child);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(context instanceof MainActivity){
                        Fragment f = new DetailsFragment();
                        Bundle b = new Bundle();
                        b.putLong("id",allBrushes.get(position).getId());
                        b.putString("productName",allBrushes.get(position).getClass().getSimpleName());


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
        ViewHolder viewHolderKisti = new ViewHolder(v);
        return viewHolderKisti;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleKisti.setText(allBrushes.get(i).getName());
        //viewHolder.itemDetail.setText(details[i]);
        holder.itemImageKisti.setImageResource(context.getResources().getIdentifier
                (allBrushes.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allBrushes.size();
    }
    private FragmentActivity myContext;

}


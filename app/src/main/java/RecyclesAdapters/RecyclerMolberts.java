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
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.EaselDao;
import asavin.mvp.model.dao.PaintDao;
import asavin.mvp.model.entity.painting.Easel;
import asavin.mvp.model.entity.painting.Paint;
import asavin.mvp.view.fragments.DetailsFragment;

/**
 * Created by Krist on 11.11.2017.
 */


public class RecyclerMolberts extends RecyclerView.Adapter<RecyclerMolberts.ViewHolder> {
    EaselDao easelDao;
    List<Easel> allEasels;
    Context context;
    public RecyclerMolberts (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        easelDao = daoSession.getEaselDao();

        allEasels = easelDao.loadAll();

    }




    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageMolberts ;
        public TextView itemTitleMolberts ;
        //public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageMolberts  = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleMolberts  = (TextView)itemView.findViewById(R.id.item_title_child);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(context instanceof MainActivity){
                        Fragment f = new DetailsFragment();
                        Bundle b = new Bundle();
                        b.putLong("id",allEasels.get(position).getId());
                        b.putString("productName",allEasels.get(position).getClass().getSimpleName());


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
        ViewHolder viewHolderMolberts  = new ViewHolder(v);
        return viewHolderMolberts ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleMolberts .setText(allEasels.get(i).getName());
        holder.itemImageMolberts.setImageResource(context.getResources().getIdentifier
                (allEasels.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
        //viewHolder.itemDetail.setText(details[i]);
//        holder.itemImageMolberts .setImageResource(imagesMolberts [i]);
    }

    @Override
    public int getItemCount() {
        return allEasels.size();
    }
    private FragmentActivity myContext;

}


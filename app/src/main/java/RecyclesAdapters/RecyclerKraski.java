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
import asavin.mvp.model.dao.PaintDao;
import asavin.mvp.model.dao.PaperDao;
import asavin.mvp.model.entity.painting.Paint;
import asavin.mvp.model.entity.painting.Paper;
import asavin.mvp.view.fragments.DetailsFragment;

/**
 * Created by Krist on 11.11.2017.
 */


public class RecyclerKraski extends RecyclerView.Adapter<RecyclerKraski.ViewHolder> {

    PaintDao paintDao;
    List<Paint> allPaints;
    Context context;
    public RecyclerKraski (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        paintDao = daoSession.getPaintDao();

        allPaints = paintDao.loadAll();

    }

    private int[] imagesKraski = {
            R.drawable.guache,
            R.drawable.akryl,
            R.drawable.pigment,
            R.drawable.maslo1,
            R.drawable.akvare,
            R.drawable.tempera

    };



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageKraski;
        public TextView itemTitleKraski;
        //public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageKraski = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleKraski = (TextView)itemView.findViewById(R.id.item_title_child);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(context instanceof MainActivity){
                        Fragment f = new DetailsFragment();
                        Bundle b = new Bundle();
                        b.putLong("id",allPaints.get(position).getId());
                        b.putString("productName",allPaints.get(position).getClass().getSimpleName());


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
        ViewHolder viewHolderKraski = new ViewHolder(v);
        return viewHolderKraski;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleKraski.setText(allPaints.get(i).getName()+" "+allPaints.get(i).getId());
        //viewHolder.itemDetail.setText(details[i]);
        holder.itemImageKraski.setImageResource(context.getResources().getIdentifier(allPaints.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allPaints.size();
    }
    private FragmentActivity myContext;

}

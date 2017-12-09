package RecyclesAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import asavin.mvp.model.dao.FeltpenDao;
import asavin.mvp.model.entity.bucket.BucketUtil;
import asavin.mvp.model.entity.child.Feltpen;
import asavin.mvp.view.fragments.DetailsFragment;

/**
 * Created by Krist on 11.11.2017.
 */


public class Child_Recycler_Flomast extends RecyclerView.Adapter<Child_Recycler_Flomast.ViewHolder> {
    Context context;
    FeltpenDao feltPenDao;
    List<Feltpen> allFeltpens;
    public Child_Recycler_Flomast (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        feltPenDao = daoSession.getFeltpenDao();



        allFeltpens =
           feltPenDao.loadAll();

        //feltPenDao.loadAll();

        Log.d("size","sss");

//        toyDao = new ToyDao(daoSession);



//        new Context(null).getApplicationContext()

    }
//    private String[] titlesFlomast = {
//            "Перманент. маркеры",
//            "Детские фломастеры",
//            "Стираемые маркеры",
//            "Маркеры-выделители",
//            "Маркер краска"
//            };

//    private int[] imagesFlomast= {
//            R.drawable.marker_permanentnyj,
//            R.drawable.flom_detskie_fl,
//            R.drawable.marker_stir,
//            R.drawable.marker_videl,
//            R.drawable.marker_kraska,
//            R.drawable.marker_permanentnyj,
//            R.drawable.flom_detskie_fl,
//            R.drawable.marker_stir,
//            R.drawable.marker_videl,
//            R.drawable.marker_kraska
//    };



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
                        b.putLong("id",allFeltpens.get(position).getId());
                        b.putString("productName",allFeltpens.get(position).getClass().getSimpleName());


                        f.setArguments(b);


                        ((MainActivity)context).OpenFragment(f);
                    }
                    BucketUtil.getBucket().addToBucket(allFeltpens.get(position).getId(), allFeltpens.get(position).getName(),context);
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
        holder.itemTitleVal.setText(allFeltpens.get(i).getName());
        holder.itemImageVal.setImageResource(context.getResources().getIdentifier(allFeltpens.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));



    }

    @Override
    public int getItemCount() {
        Log.d("size",""+ allFeltpens.size());
        return allFeltpens.size();
    }


}


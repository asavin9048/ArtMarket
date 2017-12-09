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
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.DecoratingDao;
import asavin.mvp.model.dao.SchoolDao;
import asavin.mvp.model.entity.child.School;
import asavin.mvp.model.entity.hobbie.Decorating;
import asavin.mvp.view.fragments.DetailsFragment;

/**
 * Created by Krist on 11.11.2017.
 */


public class HobbieRecycler_Decorir extends RecyclerView.Adapter<HobbieRecycler_Decorir.ViewHolder> {

    DecoratingDao decoratingDao;
    List<Decorating> allDecorating;
    Context context;

    public HobbieRecycler_Decorir (Context context){

        this.context = context;

        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        decoratingDao = daoSession.getDecoratingDao();

        allDecorating = decoratingDao.loadAll();

    }


//    private String[] titlesDecorir = {
//            "Наклейки",
//            "Структурные гели",
//            "Лаки",
//            "Контуры",
//            "Трафареты",
//            "Блестки"
//            };

//    private int[] imagesDecorir= {
//            R.drawable.decor_nakl,
//            R.drawable.decor_struc,
//            R.drawable.decor_lak,
//            R.drawable.decor_contour,
//            R.drawable.decor_traph,
//            R.drawable.decor_blestki
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
                        b.putLong("id",allDecorating.get(position).getId());
                        b.putString("productName",allDecorating.get(position).getClass().getSimpleName());


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
        holder.itemTitleVal.setText(allDecorating.get(i).getName());
        holder.itemImageVal.setImageResource(context.getResources().getIdentifier
                (allDecorating.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allDecorating.size();
    }


}


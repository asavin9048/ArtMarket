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
import asavin.mvp.model.dao.GuideDao;
import asavin.mvp.model.dao.SchoolDao;
import asavin.mvp.model.entity.child.School;
import asavin.mvp.model.entity.guide.Guide;
import asavin.mvp.view.fragments.DetailsFragment;
import asavin.mvp.view.fragments.GuideFragment;

/**
 * Created by 1 on 08.12.2017.
 */

public class GuideRecycler extends RecyclerView.Adapter<GuideRecycler.ViewHolder> {

    GuideDao guideDao;
    List<Guide> allGuides;
    Context context;
    public GuideRecycler (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        guideDao = daoSession.getGuideDao();

        allGuides = guideDao.loadAll();



    }


//    private String[] titlesShcol = {
//            "Папки",
//            "Пеналы",
//            "Тетради",
//            "Ручки",
//            "Дневники"
//            };

//    private int[] imagesShcol= {
//            R.drawable.papka,
//            R.drawable.penal,
//            R.drawable.tetradi,
//            R.drawable.ruchki,
//            R.drawable.dnevnik
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
                        Fragment f = new GuideFragment();
                        Bundle b = new Bundle();
                        b.putLong("id",allGuides.get(position).getId());

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
        holder.itemTitleVal.setText(allGuides.get(i).getName());
//        holder.itemImageVal.setImageResource([i]);
    }

    @Override
    public int getItemCount() {
        return allGuides.size();
    }


}

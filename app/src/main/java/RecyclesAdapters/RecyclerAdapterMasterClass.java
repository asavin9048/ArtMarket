package RecyclesAdapters;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import asavin.mvp.model.dao.BrandDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.GuideDao;
import asavin.mvp.model.entity.brand.Brand;
import asavin.mvp.model.entity.guide.Guide;
import asavin.mvp.view.fragments.DetailsFragment;
import asavin.mvp.view.fragments.GuideFragment;

public class RecyclerAdapterMasterClass extends RecyclerView.Adapter<RecyclerAdapterMasterClass.ViewHolder> {//https://www.youtube.com/watch?v=LKK2qgvsuDU
    Context context;
    GuideDao guideDao;
    List<Guide> allGuides;
    public RecyclerAdapterMasterClass (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        guideDao = daoSession.getGuideDao();



        allGuides =
                guideDao.loadAll();

        //feltPenDao.loadAll();

        Log.d("size","sss");

//        toyDao = new ToyDao(daoSession);



//        new Context(null).getApplicationContext()

    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageMastClass;
        public TextView itemTitleMastClass;


        public ViewHolder(View itemView) {
            super(itemView);
            itemImageMastClass = (ImageView)itemView.findViewById(R.id.item_image_frame);
            itemTitleMastClass = (TextView)itemView.findViewById(R.id.item_title_frame);


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
                .inflate(R.layout.card_layout_frame, parent, false);
        ViewHolder viewHolderMastClass = new ViewHolder(v);
        return viewHolderMastClass;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleMastClass.setText(allGuides.get(i).getName());
        //viewHolder.itemDetail.setText(details[i]);
        holder.itemImageMastClass.setImageResource(context.getResources().getIdentifier(allGuides.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allGuides.size();
    }
    private FragmentActivity myContext;

}



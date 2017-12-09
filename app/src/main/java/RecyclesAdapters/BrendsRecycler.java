package RecyclesAdapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.R;

import java.util.List;

import asavin.mvp.App;
import asavin.mvp.model.dao.BrandDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.FeltpenDao;
import asavin.mvp.model.entity.brand.Brand;
import asavin.mvp.model.entity.child.Feltpen;

/**
 * Created by Krist on 11.11.2017.
 */


public class BrendsRecycler extends RecyclerView.Adapter<BrendsRecycler.ViewHolder> {


    Context context;
    BrandDao brandDao;
    List<Brand> allBrands;
    public BrendsRecycler (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        brandDao = daoSession.getBrandDao();



        allBrands =
                brandDao.loadAll();

        //feltPenDao.loadAll();

        Log.d("size","sss");

//        toyDao = new ToyDao(daoSession);



//        new Context(null).getApplicationContext()

    }



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageBrends;
        public TextView itemTitleBrends;
        //public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageBrends = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleBrends = (TextView)itemView.findViewById(R.id.item_title_child);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

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
                .inflate(R.layout.card_layout_brends, parent, false);
        ViewHolder viewHolderBrends = new ViewHolder(v);
        return viewHolderBrends;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleBrends.setText(allBrands.get(i).getName());
        //viewHolder.itemDetail.setText(details[i]);
        holder.itemImageBrends.setImageResource(context.getResources().getIdentifier(allBrands.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allBrands.size();
    }
    private FragmentActivity myContext;

}


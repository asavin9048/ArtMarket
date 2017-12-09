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
import asavin.mvp.model.dao.PaperDao;
import asavin.mvp.model.dao.PencilDao;
import asavin.mvp.model.entity.painting.Paper;
import asavin.mvp.model.entity.painting.Pencil;
import asavin.mvp.view.fragments.DetailsFragment;

public class RecyclerKarand extends RecyclerView.Adapter<RecyclerKarand.ViewHolder> {

    PencilDao pencilDao;
    List<Pencil> allPencils;
    Context context;
    public RecyclerKarand (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        pencilDao = daoSession.getPencilDao();

        allPencils = pencilDao.loadAll();

    }



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageKarand;
        public TextView itemTitleKarand;
        //public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageKarand = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleKarand = (TextView)itemView.findViewById(R.id.item_title_child);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(context instanceof MainActivity){
                        Fragment f = new DetailsFragment();
                        Bundle b = new Bundle();
                        b.putLong("id",allPencils.get(position).getId());
                        b.putString("productName",allPencils.get(position).getClass().getSimpleName());


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
        ViewHolder viewHolderKarand = new ViewHolder(v);
        return viewHolderKarand;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleKarand.setText(allPencils.get(i).getName());
        //viewHolder.itemDetail.setText(details[i]);
        holder.itemImageKarand.setImageResource(context.getResources().getIdentifier
                (allPencils.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allPencils.size();
    }
    private FragmentActivity myContext;

}

package asavin.mvp.view.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.R;

import java.util.List;

import asavin.mvp.App;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.ToyDao;
import asavin.mvp.model.entity.child.Toy;

public class Child_Recycler_Igrush extends RecyclerView.Adapter<Child_Recycler_Igrush.ViewHolder> {
    ToyDao toyDao;
    List<Toy> allToys;
    public Child_Recycler_Igrush(Context context){
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        toyDao = daoSession.getToyDao();

        allToys = toyDao.loadAll();

//        toyDao = new ToyDao(daoSession);



//        new Context(null).getApplicationContext()

    }

    private String[] titlesIgrush = {
            "Игрушки из фетра",
            "Игрушки из ткани"
            };

    private int[] imagesIgrush= {
            R.drawable.igr_fetr2,
            R.drawable.igr_tkan
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
        holder.itemTitleVal.setText(allToys.get(i).getName()/*titlesIgrush[i]*/);
        holder.itemImageVal.setImageResource(imagesIgrush[i]);
    }

    @Override
    public int getItemCount() {
        return allToys.size();
    }


}

package RecyclesAdapters;


import android.content.Context;
import android.os.Bundle;
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
import com.example.krist.artmarket.RecyclerViewClickListener;

import java.util.List;

import asavin.mvp.App;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.SculptinsideDao;
import asavin.mvp.model.entity.sculpture.Sculptinside;
import asavin.mvp.view.fragments.DetailsFragment;

public class RecyclerAdapterSculpt extends RecyclerView.Adapter<RecyclerAdapterSculpt.ViewHolder> {



    Context context;
//    public RecyclerAdapterSculpt (Context context,RecyclerViewClickListener listener){
//        mListener = listener;
//        this.context = context;
//        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
//        sculptInsideDao = daoSession.getSculptinsideDao();
//
//        allSculptinsides = sculptInsideDao.loadAll();
//
//    }

    private RecyclerViewClickListener mListener;
    public RecyclerAdapterSculpt(RecyclerViewClickListener listener) {
        mListener = listener;
    }

    private String[] titlesSculpt = {
            "Cкульптура",
            "Резьба по дереву"};

    private int[] imagesSculpt = {
            R.drawable.sculpt,
            R.drawable.resba};

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RecyclerViewClickListener mListener;
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;

        public ViewHolder(View itemView,RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;


            itemImage = (ImageView)itemView.findViewById(R.id.item_image_sculpt);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title_sculpt);
            itemView.setOnClickListener(this);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v,getLayoutPosition());
//            int position = getAdapterPosition();
//
//            if(context instanceof MainActivity){
//                Fragment f = new DetailsFragment();
//                Bundle b = new Bundle();
//                b.putLong("id",allSculptinsides.get(position).getId());
//                b.putString("productName",allSculptinsides.get(position).getClass().getSimpleName());
//
//
//                f.setArguments(b);
//
//
//                ((MainActivity)context).OpenFragment(f);
//            }


        }
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.card_layout_sculpt, parent, false);
        return new RecyclerAdapterSculpt.ViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitle.setText(titlesSculpt[i]);
        holder.itemImage.setImageResource(imagesSculpt[i]);
//        holder.itemImageSculpt.setImageResource(imagesSculpt[i]);
    }

    @Override
    public int getItemCount() {
        return titlesSculpt.length;
    }
    private FragmentActivity myContext;

}



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
import asavin.mvp.model.dao.ChildProductDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.SchoolDao;
import asavin.mvp.model.entity.child.School;
import asavin.mvp.model.entity.structure.ChildProduct;
import asavin.mvp.view.fragments.DetailsFragment;

public class RecyclerAdapterChild extends RecyclerView.Adapter<RecyclerAdapterChild.ViewHolder> {

//    ChildProductDao childProductDao;
//    List<ChildProduct> allChildProducts;
    Context context;

    private RecyclerViewClickListener mListener;

    public RecyclerAdapterChild(RecyclerViewClickListener listener) {mListener = listener;}

    private String[] titlesChild = {
            "Маркеры",
            "Все для создания игрушек",
            "Пазлы",
            "Раскраски",
            "Школьные принадлежности",
            "Пластилин"};



    private int[] imagesChild = {
            R.drawable.marker_permanentnyj,
            R.drawable.igr_fetr1,
            R.drawable.pazlimen,
            R.drawable.raskras,
            R.drawable.school_prin,
            R.drawable.plastiln};



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RecyclerViewClickListener mListener;

        public int currentItem;
        public ImageView itemImageChild;
        public TextView itemTitleChild;


        public ViewHolder(View itemView,RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;


            itemImageChild = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleChild = (TextView)itemView.findViewById(R.id.item_title_child);
            itemView.setOnClickListener(this);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition());
        }
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        return new RecyclerAdapterChild.ViewHolder(v, mListener);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleChild.setText(titlesChild[i]);
        holder.itemImageChild.setImageResource(imagesChild[i]);
    }

    @Override
    public int getItemCount() {
        return titlesChild.length;
    }
    private FragmentActivity myContext;

}
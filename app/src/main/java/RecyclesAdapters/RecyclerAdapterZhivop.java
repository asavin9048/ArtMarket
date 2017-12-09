package RecyclesAdapters;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.R;
import com.example.krist.artmarket.RecyclerViewClickListener;

public class RecyclerAdapterZhivop extends RecyclerView.Adapter<RecyclerAdapterZhivop.ViewHolder> {

    private RecyclerViewClickListener mListener;
    public RecyclerAdapterZhivop(RecyclerViewClickListener listener) {
        mListener = listener;
    }

    private String[] titlesZhivopis = {
            "Холсты",
            "Краски",
            "Карандаши",
            "Бумага",
            "Кисти и мастихины",
            "Мольберты"};



    private int[] imagesZhivopis = {
            R.drawable.holsti,
            R.drawable.kraski,
            R.drawable.karandash,
            R.drawable.bumaga,
            R.drawable.kisti,
            R.drawable.molbert
            };



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public int currentItem;
        public ImageView itemImageZhivopis;
        public TextView itemTitleZhivopis;


        public ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemImageZhivopis = (ImageView)itemView.findViewById(R.id.item_image_zhivopis);
            itemTitleZhivopis = (TextView)itemView.findViewById(R.id.item_title_zhivopis);


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
        View v = LayoutInflater.from(context).inflate(R.layout.card_layout_zhivopis, parent, false);
        return new RecyclerAdapterZhivop.ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleZhivopis.setText(titlesZhivopis[i]);

        holder.itemImageZhivopis.setImageResource(imagesZhivopis[i]);
    }

    @Override
    public int getItemCount() {
        return titlesZhivopis.length;
    }
    private FragmentActivity myContext;

}




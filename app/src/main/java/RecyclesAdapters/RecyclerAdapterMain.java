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

public class RecyclerAdapterMain extends RecyclerView.Adapter<RecyclerAdapterMain.ViewHolder> {
    private RecyclerViewClickListener mListener;
    public RecyclerAdapterMain(RecyclerViewClickListener listener) {
        mListener = listener;
    }
    private String[] titlesMain = {

            "Мастер-классы",
            "Продажа картин",
            "Бренды"};

   /* private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};*/

    private int[] imagesMain = {

            R.drawable.mastr_class,
            R.drawable.artworks,
            R.drawable.brends};



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public ImageView itemImageMain;
        public TextView itemTitleMain;
        private RecyclerViewClickListener mListener;

        public ViewHolder(View itemView,RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemImageMain = (ImageView)itemView.findViewById(R.id.item_image_main);
            itemTitleMain = (TextView)itemView.findViewById(R.id.item_title_main);
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
        View v = LayoutInflater.from(context).inflate(R.layout.card_layout_main, parent, false);
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

            holder.itemTitleMain.setText(titlesMain[i]);
            holder.itemImageMain.setImageResource(imagesMain[i]);
    }

    @Override
    public int getItemCount() {
        return titlesMain.length;
    }
    private FragmentActivity myContext;

}




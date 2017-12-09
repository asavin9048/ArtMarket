package RecyclesAdapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.R;

/**
 * Created by Krist on 11.11.2017.
 */


public class Recycler_ArtSale extends RecyclerView.Adapter<Recycler_ArtSale.ViewHolder> {

    private String[] SizesArtSale  = {
            "60x80 см.",
            "30х40 см.",
            "30х40 см.",
            "30х40 см.",
            "60x80 см."
            };
    private String[] PricesArtSale  = {
            "3200 грн.",
            "2800 грн.",
            "700 грн.",
            "2500 грн.",
            "3200 грн.",
    };


    private int[] imagesArtSale = {
            R.drawable.art_pines,
            R.drawable.art_lights,
            R.drawable.art_grapes,
            R.drawable.art_wood_bridge,
            R.drawable.art_peonies
    };



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageVal;
        public TextView itemSizesVal;
        public TextView itemPriceVal;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageVal = (ImageView)itemView.findViewById(R.id.artworkOnSale);
            itemSizesVal = (TextView)itemView.findViewById(R.id.item_size);
            itemPriceVal = (TextView)itemView.findViewById(R.id.item_title_price);

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
                .inflate(R.layout.card_layout_artsale, parent, false);
        ViewHolder viewHolderVal = new ViewHolder(v);
        return viewHolderVal;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemSizesVal.setText(SizesArtSale[i]);
        holder.itemPriceVal.setText(PricesArtSale[i]);
        holder.itemImageVal.setImageResource(imagesArtSale[i]);
    }

    @Override
    public int getItemCount() {
        return SizesArtSale.length;
    }


}


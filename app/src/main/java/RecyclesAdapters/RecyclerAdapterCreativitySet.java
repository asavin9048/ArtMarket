package RecyclesAdapters;


import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.R;

public class RecyclerAdapterCreativitySet extends RecyclerView.Adapter<RecyclerAdapterCreativitySet.ViewHolder> {

    private String[] titlesArtSet = {
            "Фломастеры",
            "Игрушки",
            "Пазлы",
            "Раскраски",
            "Школьные принадлежности",
            "Пластилин",
            "Блокноты"};

   /* private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};*/

    private int[] imagesArtSet = {
            R.drawable.val,
            R.drawable.hobbie2,
            R.drawable.hobbie3,
            R.drawable.hobbie4,
            R.drawable.hobbie5,
            R.drawable.hobbie6,
            R.drawable.hobbie7,
            R.drawable.album1};



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImageArtSet;
        public TextView itemTitleArtSet;
        //public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageArtSet = (ImageView)itemView.findViewById(R.id.item_image_artset);
            itemTitleArtSet = (TextView)itemView.findViewById(R.id.item_title_artset);
            //itemDetail =(TextView)itemView.findViewById(R.id.item_detail);

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
                .inflate(R.layout.card_layout_artset, parent, false);
        ViewHolder viewHolderArtSet = new ViewHolder(v);
        return viewHolderArtSet;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleArtSet.setText(titlesArtSet[i]);
        //viewHolder.itemDetail.setText(details[i]);
        holder.itemImageArtSet.setImageResource(imagesArtSet[i]);
    }

    @Override
    public int getItemCount() {
        return titlesArtSet.length;
    }
    private FragmentActivity myContext;
    /*private void OpenFragment(Fragment f)//на вход как параметр подается название фрагмента (java класса)
    {
        if (f != null) {

            FragmentManager fragmentManager = myContext.getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, f).addToBackStack("1").commit();}
    }*/
}

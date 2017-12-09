package RecyclesAdapters;

/**
 * Created by Shade on 5/9/2016.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.R;
import com.example.krist.artmarket.RecyclerViewClickListener;

public class RecyclerAdapterHobbie extends RecyclerView.Adapter<RecyclerAdapterHobbie.ViewHolder> {

    private RecyclerViewClickListener mListener;

    public RecyclerAdapterHobbie(RecyclerViewClickListener listener) {mListener = listener;}

    private String[] titles = {"Валяние",
            "Выжигание",
            "Декор",
            "Декупаж",
            "Квиллинг",
            "Золочение",
            "Блокноты",
            "Гримм"};

      private int[] images = {
            R.drawable.val,
            R.drawable.hobbie2,
            R.drawable.hobbie3,
            R.drawable.hobbie4,
            R.drawable.hobbie5,
            R.drawable.hobbie6,
            R.drawable.hobbie7,
            R.drawable.album1};



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private RecyclerViewClickListener mListener;
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;


        public ViewHolder(View itemView,RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition());
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.card_layout_hobbie, viewGroup, false);
        return new RecyclerAdapterHobbie.ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
    private FragmentActivity myContext;
    private void OpenFragment(Fragment f)//на вход как параметр подается название фрагмента (java класса)
    {
        if (f != null) {

            FragmentManager fragmentManager = myContext.getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, f).addToBackStack("1").commit();}
    }
}
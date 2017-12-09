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
import asavin.mvp.model.dao.FrameDao;
import asavin.mvp.model.entity.Frame.Frame;
import asavin.mvp.model.entity.structure.ChildProduct;
import asavin.mvp.view.fragments.DetailsFragment;

public class RecyclerAdapterFrame extends RecyclerView.Adapter<RecyclerAdapterFrame.ViewHolder> {

    FrameDao frameDao;
    List<Frame> allFrames;
    Context context;

    public RecyclerAdapterFrame (Context context){
        this.context = context;
        DaoSession daoSession = ((App) context.getApplicationContext()).getDaoSession();
        frameDao = daoSession.getFrameDao();


        allFrames = frameDao.loadAll();



    }





    class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        public int currentItem;
        public ImageView itemImageFrame;
        public TextView itemTitleFrame;
        //public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImageFrame = (ImageView)itemView.findViewById(R.id.item_image_frame);
            itemTitleFrame = (TextView)itemView.findViewById(R.id.item_title_frame);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(context instanceof MainActivity){
                Fragment f = new DetailsFragment();
                Bundle b = new Bundle();
                b.putLong("id",allFrames.get(position).getId());
                b.putString("productName",allFrames.get(position).getClass().getSimpleName());


                f.setArguments(b);


                ((MainActivity)context).OpenFragment(f);
            }
        }
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.card_layout_frame, parent, false);
        return new RecyclerAdapterFrame.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.itemTitleFrame.setText(allFrames.get(i).getName());
        holder.itemImageFrame.setImageResource(context.getResources().getIdentifier
                (allFrames.get(i).getImageResource(), "drawable", context.getApplicationContext().getPackageName()));
    }

    @Override
    public int getItemCount() {
        return allFrames.size();
    }
    private FragmentActivity myContext;

}


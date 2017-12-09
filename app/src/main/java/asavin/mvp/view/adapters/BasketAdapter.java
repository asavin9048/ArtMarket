package asavin.mvp.view.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krist.artmarket.R;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.annotation.Id;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import RecyclesAdapters.Child_Recycler_Shcol;
import asavin.mvp.App;
import asavin.mvp.model.dao.BucketDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.SchoolDao;
import asavin.mvp.model.entity.bucket.Bucket;
import asavin.mvp.model.entity.child.School;

/**
 * Created by 1 on 07.12.2017.
 */


public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder> {
    BucketDao bucketDao;
    List<Bucket> allBucketItems;
    DaoSession daoSession;
    public BasketAdapter (Context context){
         daoSession = ((App) context.getApplicationContext()).getDaoSession();
        bucketDao = daoSession.getBucketDao();

        allBucketItems = bucketDao.loadAll();

    }

    private String[] titlesShcol = {
            "Папки",
            "Пеналы",
            "Тетради",
            "Ручки",
            "Дневники"
    };

    private int[] imagesShcol= {
            R.drawable.papka,
            R.drawable.penal,
            R.drawable.tetradi,
            R.drawable.ruchki,
            R.drawable.dnevnik,
            R.drawable.papka,
            R.drawable.penal,
            R.drawable.tetradi,
            R.drawable.ruchki,
            R.drawable.dnevnik
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
    public BasketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        BasketAdapter.ViewHolder viewHolderVal = new BasketAdapter.ViewHolder(v);
        return viewHolderVal;
    }

    @Override
    public void onBindViewHolder(BasketAdapter.ViewHolder holder, int i) {

        long productId = allBucketItems.get(i).getProductId();
        String productName = allBucketItems.get(i).getProductName();


        Class<?> c = null;
        try {
            c = Class.forName("asavin.mvp.model.dao.DaoSession");



//            Method method = c.getDeclaredMethod ("get"+productName.substring(0, 1).toUpperCase() + productName.substring(1)+"Dao");
//
//
//            Log.d("bucket",((AbstractDao) method.invoke(daoSession)).
//                    loadByRowId(productId)
//                    .getClass().
//                            getName());


            Log.d("bucketsql",""+
                    daoSession.getDatabase().rawQuery("SELECT * FROM "+
                            productName +" WHERE _id = "+productId,new String[]{}).getColumnNames().toString());




            Cursor cursor = daoSession.getDatabase().rawQuery("SELECT * FROM "+
                    productName +" WHERE _id = "+productId,new String[]{});

            while (cursor.moveToNext()){
                holder.itemTitleVal.setText(cursor.getString(cursor.getColumnIndex("NAME")));
//                Log.d("namee",cursor.getName(cursor.getColumnIndex("NAME")));
            }


//            holder.itemTitleVal.setText(((AbstractDao<? extends Integer,Long>) method.invoke(daoSession)).
//                    loadByRowId(productId).;



//            Object o = ((AbstractDao) method.invoke(daoSession)).loadByRowId(productId).getClass()
//                    .cast(((AbstractDao) method.invoke(daoSession)).loadByRowId(productId).getClass().getName());
//
//            o.getClass()

//            holder
            holder.itemImageVal.setImageResource(imagesShcol[i]);
        }catch (Exception e){
            e.printStackTrace();
            Log.d("bucket","id "+productId);
        }
//        catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int getItemCount() {
        return allBucketItems.size();
    }

}
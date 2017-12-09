package com.example.krist.artmarket;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.greendao.AbstractDao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import asavin.mvp.App;
import asavin.mvp.model.dao.BrushDao;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.dao.GuideDao;
import asavin.mvp.model.dao.PaintDao;
import asavin.mvp.model.entity.guide.Guide;
import asavin.mvp.model.entity.painting.Brush;
import asavin.mvp.model.entity.painting.Paint;
import asavin.mvp.view.fragments.DetailsFragment;
import asavin.mvp.view.fragments.GuideFragment;

/**
 * Created by 1 on 08.12.2017.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    GuideDao guideDao;
    List<Guide> allGuides;
    Context context;
    DaoSession daoSession;
    ArrayList< Object>queryResult;

    public void updateList(String text){
        Collection<AbstractDao<?, ?>> daos = new ArrayList<>();
        daos.add(daoSession.getBrushDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getBurningDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getCanvasDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getChildProductDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getColoringDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getDecoratingDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getDecoupageDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getDecoratingDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getEaselDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getFeltpenDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getFrameDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getGildingDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getHobbieProductDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getPaintDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getPaperDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getPencilDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getPuzzleDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getQuillingDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getSchoolDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getSculptinsideDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getThreadDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getToyDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));
        daos.add(daoSession.getWallowDao());//.remove(Arrays.asList(daoSession.getBrandDao(),daoSession.getGuideDao()));

        for (Paint p: daoSession.getPaintDao().loadAll()){Log.d("nameep",p.getName());}


        Log.d("sssss",""+daoSession.getPaintDao().queryBuilder().where(PaintDao.Properties.Name.like("akryl")).list().size());


        for(AbstractDao dao:daos){

            Log.d("texdt",text);
            queryResult.addAll(
                    dao.queryRawCreate("WHERE T.NAME like '%"+text+"%'").list());
//            Cursor c = daoSession.getDatabase().rawQuery("select * from "+dao.getTablename()+" where name contains \""+text+"\"",new String[]{});

//            for()
        }
//        queryResult.addAll(daoSession.getBrushDao().queryBuilder().where(BrushDao.Properties.Name.like(text));



    }


    public SearchAdapter (Context context,String text){
        queryResult = new ArrayList<>();
        this.context = context;
        daoSession = ((App) context.getApplicationContext()).getDaoSession();
//        guideDao = daoSession.getGuideDao();

//        allGuides = guideDao.loadAll();
        updateList(text);
    }
//    private String[] titlesShcol = {
//            "Папки",
//            "Пеналы",
//            "Тетради",
//            "Ручки",
//            "Дневники"
//            };

//    private int[] imagesShcol= {
//            R.drawable.papka,
//            R.drawable.penal,
//            R.drawable.tetradi,
//            R.drawable.ruchki,
//            R.drawable.dnevnik
//    };



    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
//        public ImageView itemImageVal;
        public TextView itemTitleVal;


        public ViewHolder(View itemView) {
            super(itemView);
//            itemImageVal = (ImageView)itemView.findViewById(R.id.item_image_child);
            itemTitleVal = (TextView)itemView.findViewById(R.id.product_name);

//            itemView.setOnC

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(context instanceof MainActivity){
                        Fragment f = new DetailsFragment();
                        Bundle b = new Bundle();


                        Field field = null;
                        String tableName = daoSession.getDao(queryResult.get(position).getClass()).getTablename();
                        Long id = null;
                        try {
                            field = queryResult.get(position).getClass().getField("id");


                        id = (Long) field
                                .get
                                        (queryResult.get(position));

                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                        b.putLong("id",id);
                        b.putString("productName",tableName);



                        f.setArguments(b);

                        ((MainActivity)context).OpenFragment(f);
                    }
                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }
            });
        }
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_search_item, parent, false);
        SearchAdapter.ViewHolder viewHolderVal = new SearchAdapter.ViewHolder(v);
        return viewHolderVal;
    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolder holder, int i) {



        String tableName = daoSession.getDao(queryResult.get(i).getClass()).getTablename();
        String pk = (daoSession.getDao(queryResult.get(i).getClass()).getPkColumns()[0]);


        Object o = null;
        Long objectValue = null;
        try {

//            o = (daoSession.getDao((Class<? extends Object>) queryResult.get(i)).get);
            Field field = queryResult.get(i).getClass().getField("id");
            field.setAccessible(true);


            for(Field f:queryResult.get(i).getClass().getDeclaredFields());{
                Log.d("fieldd",field.getName());
            }
             objectValue = (Long) field
                     .get
                             (queryResult.get(i));



        } catch (SecurityException e) {  } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        Cursor c = daoSession.getDatabase().rawQuery("SELECT * FROM "+tableName+" WHERE _ID = "+(objectValue),new String[]{});
        c.moveToFirst();

        for(String s:c.getColumnNames())
        {Log.d("cc",s);}

        c.moveToFirst();
        String name = c.getString(c.getColumnIndex("NAME"));

        holder.itemTitleVal.setText(name);
//        holder.itemImageVal.setImageResource([i]);
    }

    @Override
    public int getItemCount() {
        Log.d("siiize",queryResult.size()+"");
        return queryResult.size();
    }


}

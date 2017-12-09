package asavin.mvp.view.fragments;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.krist.artmarket.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayerFragment;

import asavin.mvp.App;
import asavin.mvp.model.dao.DaoSession;
import asavin.mvp.model.entity.brand.Brand;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements View.OnClickListener{


    public DetailsFragment() {
        // Required empty public constructor
    }


    View v;

    String tableName;
    Long id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String tableName = getArguments().getString("productName");
        Long id = getArguments().getLong("id");

        DaoSession daoSession = ((App)getActivity().getApplicationContext()).getDaoSession();



        Log.d("query","SELECT * FROM "+
                tableName +" WHERE _id = "+id);

        Cursor cursor = daoSession.getDatabase().rawQuery("SELECT * FROM "+
                tableName +" WHERE _id = "+id,new String[]{});




//        while (cursor.moveToNext()){
//            Log.d("",cursor.getString(cursor.getColumnIndex("NAME")));
////                Log.d("namee",cursor.getName(cursor.getColumnIndex("NAME")));
//        }

//        for(String s:cursor.getColumnNames())
//        {
//            cursor.moveToFirst();
//            Log.d("tttt",s+" "+cursor.getString(0));
//        }



        cursor.moveToFirst();
        String productName = cursor.getString(cursor.getColumnIndex("NAME"));

//        cursor.moveToFirst();

        Brand brand = daoSession.getBrandDao().loadByRowId(daoSession.getBrandDao().
                loadByRowId(cursor.getLong(cursor.getColumnIndex("BRAND_ID"))).getId());


        String productImageResourceName = cursor.getString(cursor.getColumnIndex("IMAGE_RESOURCE"));
        Context context = getActivity().getApplicationContext();

        int productImageResourceId = context.getResources().getIdentifier(productImageResourceName, "drawable", getActivity().getApplicationContext().getPackageName());
        int brandImageResourceId = context.getResources().getIdentifier(brand.getImageResource(), "drawable", getActivity().getApplicationContext().getPackageName());


        v = inflater.inflate(R.layout.fragment_details, container, false);

        ((ImageView)v.findViewById(R.id.product_image_view)).setImageResource(productImageResourceId);
        ((ImageView)v.findViewById(R.id.brandImage)).setImageResource(brandImageResourceId);
        ((TextView)v.findViewById(R.id.product_name)).setText(productName);
        ((TextView)v.findViewById(R.id.brand_name)).setText(brand.getName());

//        VideoView videoView = (VideoView) v.findViewById(R.id.youtubeplayer);
//        videoView.setVideoURI( Uri.parse("https://www.youtube.com/watch?v=gOsM-DYAEhY"));
//        videoView.start();

//        YouTubePlayerFragment myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager()
//                .findFragmentById(R.id.youtubeplayerfragment);
//        myYouTubePlayerFragment.initialize("AIzaSyBVSZHjAJJK8PuoNMkj6zkyjmapAPf8rtg", this);


        return v;
    }

    @Override
    public void onClick(View v) {

    }

//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//        youTubePlayer.cueVideo("9ycNQyjeD2w");
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//    }
}

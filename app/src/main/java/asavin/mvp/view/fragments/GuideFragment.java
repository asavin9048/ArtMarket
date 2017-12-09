package asavin.mvp.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.krist.artmarket.R;
import com.google.android.youtube.player.YouTubePlayerFragment;

import asavin.mvp.App;
import asavin.mvp.model.dao.GuideDao;
import asavin.mvp.model.entity.guide.Guide;


public class GuideFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_guide, container, false);


        Guide guide = ((App)getActivity().getApplicationContext()).getDaoSession().getGuideDao().loadByRowId(getArguments().getLong("id"));

        ((VideoView)v.findViewById(R.id.youtubeplayer)).setVideoURI(Uri.parse(guide.getUrl()));

        return v;
    }


}

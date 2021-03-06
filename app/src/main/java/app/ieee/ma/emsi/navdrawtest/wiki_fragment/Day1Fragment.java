package app.ieee.ma.emsi.navdrawtest.wiki_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import app.ieee.ma.emsi.navdrawtest.R;
import app.ieee.ma.emsi.navdrawtest.classes.Planing;
import app.ieee.ma.emsi.navdrawtest.viewHolder_class.Planing_ViewHolder;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.SlideInRightAnimationAdapter;


public class Day1Fragment extends Fragment {

    private String _title;
    private int _position;



    // newInstance constructor for creating fragment with arguments
    public static Day1Fragment new_instance(int page , String title)
    {
        Day1Fragment fragment1 = new Day1Fragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment1.setArguments(args);
        return  fragment1;
    }



    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _position = getArguments().getInt("someInt",0);
        _title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.day1_fragment,container,false);

        PlaningItems(view);
        return view;
    }



    private  void PlaningItems(View v)
    {
        Planing[] listPlaning = {
                    new Planing("12:15 - 14:30","ICM PLEN 1 : Monday Plenary","Salon F"),
                    new Planing("12:15 - 14:30","ICM PLEN 1 : Monday Plenary","Salon F"),
                    new Planing("12:15 - 14:30","ICM PLEN 1 : Monday Plenary","Salon F"),
                    new Planing("12:15 - 14:30","ICM PLEN 1 : Monday Plenary","Salon F"),
                    new Planing("12:15 - 14:30","ICM PLEN 1 : Monday Plenary","Salon F")
        };

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv_planing);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        // 3. create an adapter
        Planing_ViewHolder mAdapter = new Planing_ViewHolder(listPlaning);
        // 4. set adapter
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
        alphaAdapter.setDuration(2000);
        alphaAdapter.setInterpolator(new OvershootInterpolator());
        alphaAdapter.setFirstOnly(false);
        recyclerView.setAdapter(new SlideInRightAnimationAdapter(mAdapter));
    }

}

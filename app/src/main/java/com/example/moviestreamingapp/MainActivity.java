package com.example.moviestreamingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<Slide> listSlides;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView MoviesRV ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderPager = findViewById(R.id.slider_pager);
         indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);


        //prepare a list of slides

        listSlides = new ArrayList<>();
        listSlides.add(new Slide(R.drawable.slide1, "Debi/nmore text here"));
        listSlides.add(new Slide(R.drawable.slide2, "Halda/nmore text here"));
        listSlides.add(new Slide(R.drawable.slide3, "Taqdeer/nmore text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, listSlides);
        sliderPager.setAdapter(adapter);

        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,6000);

        indicator.setupWithViewPager(sliderPager,true);

        // Recyclerview Setup
        // ini data

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Kumfu Panda",R.drawable.kumfu_panda));
        lstMovies.add(new Movie("Ice Age",R.drawable.ice_age));
        lstMovies.add(new Movie("Minions",R.drawable.minions));
        lstMovies.add(new Movie("Rampage",R.drawable.rampage));




        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    class SliderTimer extends TimerTask {


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem()<listSlides.size()-1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }
                    else
                        sliderPager.setCurrentItem(0);
                }
            });


        }
    }


}
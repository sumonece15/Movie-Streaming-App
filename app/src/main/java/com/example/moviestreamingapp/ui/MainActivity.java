package com.example.moviestreamingapp.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviestreamingapp.models.Movie;
import com.example.moviestreamingapp.adapters.MovieAdapter;
import com.example.moviestreamingapp.adapters.MovieItemClickListener;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.Slide;
import com.example.moviestreamingapp.adapters.SliderPagerAdapter;
import com.example.moviestreamingapp.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> listSlides;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView MoviesRV, moviesRvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();


    }

    private void iniWeekMovies() {

        MovieAdapter weekMovieAdapter = new MovieAdapter(this, DataSource.getWeekMovies(), this);
        moviesRvWeek.setAdapter(weekMovieAdapter);
        moviesRvWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void iniPopularMovies() {
        // Recyclerview Setup
        // ini data

        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        //prepare a list of slides

        listSlides = new ArrayList<>();
        listSlides.add(new Slide(R.drawable.slide1, "Debi/nmore text here"));
        listSlides.add(new Slide(R.drawable.slide2, "Halda/nmore text here"));
        listSlides.add(new Slide(R.drawable.slide3, "Taqdeer/nmore text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, listSlides);
        sliderPager.setAdapter(adapter);

        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(sliderPager, true);
    }

    private void iniViews() {
        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        moviesRvWeek = findViewById(R.id.rv_movies_week);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        // here we send movie information to detail activity
        // also we ll create the transition animation between the two activity

        Intent intent = new Intent(this, MovieDetailActivity.class);
        // send movie information to deatilActivity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                movieImageView, "sharedName");

        startActivity(intent, options.toBundle());


        // i l make a simple test to see if the click works

        Toast.makeText(this, "item clicked : " + movie.getTitle(), Toast.LENGTH_SHORT).show();
        // it works great

    }


    class SliderTimer extends TimerTask {


        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < listSlides.size() - 1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    } else
                        sliderPager.setCurrentItem(0);
                }
            });


        }
    }


}
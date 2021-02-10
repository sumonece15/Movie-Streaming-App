package com.example.moviestreamingapp.utils;

import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies() {

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Kumfu Panda", R.drawable.kumfu_panda, R.drawable.ice_age_cover));
        lstMovies.add(new Movie("Ice Age", R.drawable.ice_age, R.drawable.ice_age_cover));
        lstMovies.add(new Movie("Minions", R.drawable.minions));
        lstMovies.add(new Movie("Rampage", R.drawable.rampage));

        return lstMovies;


    }

    public static List<Movie> getWeekMovies() {


        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Minions", R.drawable.minions));
        lstMovies.add(new Movie("Rampage", R.drawable.rampage));
        lstMovies.add(new Movie("Kumfu Panda", R.drawable.kumfu_panda, R.drawable.ice_age_cover));
        lstMovies.add(new Movie("Ice Age", R.drawable.ice_age, R.drawable.ice_age_cover));


        return lstMovies;

    }
}

package com.example.moviestreamingapp.utils;

import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.Cast;
import com.example.moviestreamingapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies() {

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Kumfu Panda", R.drawable.kumfu_panda, R.drawable.kumfu_panda_cover));
        lstMovies.add(new Movie("Ice Age", R.drawable.ice_age, R.drawable.ice_age_cover));
        lstMovies.add(new Movie("Minions", R.drawable.minions, R.drawable.minions_cover));
        lstMovies.add(new Movie("Rampage", R.drawable.rampage, R.drawable.rampage_cover));

        return lstMovies;


    }

    public static List<Movie> getWeekMovies() {


        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Minions", R.drawable.minions, R.drawable.minions_cover));
        lstMovies.add(new Movie("Rampage", R.drawable.rampage, R.drawable.rampage_cover));
        lstMovies.add(new Movie("Kumfu Panda", R.drawable.kumfu_panda, R.drawable.kumfu_panda_cover));
        lstMovies.add(new Movie("Ice Age", R.drawable.ice_age, R.drawable.ice_age_cover));


        return lstMovies;

    }

    public static List<Cast> getIceAgeMovieCast(){

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name", R.drawable.ice_age_john_leguizamo));
        mdata.add(new Cast("name", R.drawable.ice_age_ray_romano));
        mdata.add(new Cast("name", R.drawable.ice_age_jessie_j));
        mdata.add(new Cast("name", R.drawable.ice_age_denis_leary));
        mdata.add(new Cast("name", R.drawable.ice_age_simon_pegg));
        mdata.add(new Cast("name", R.drawable.ice_age_queen_latifah));
        mdata.add(new Cast("name", R.drawable.ice_age_josh_peck));

        return mdata;
    }


    public static List<Cast> getMonionsMovieCast(){

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name", R.drawable.minions_pierre_coffin));
        mdata.add(new Cast("name", R.drawable.minions_steve_coogan));
        mdata.add(new Cast("name", R.drawable.minions_allison_janney));
        mdata.add(new Cast("name", R.drawable.minions_jon_hamm));
        mdata.add(new Cast("name", R.drawable.minions_michael_keaton));
        mdata.add(new Cast("name", R.drawable.minions_geoffrey_rush));
        mdata.add(new Cast("name", R.drawable.minions_jennifer_saunders));

        return mdata;

    }
}

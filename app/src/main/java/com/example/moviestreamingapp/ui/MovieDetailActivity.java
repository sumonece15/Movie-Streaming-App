package com.example.moviestreamingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.adapters.CastAdapter;
import com.example.moviestreamingapp.models.Cast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        // ini views
        iniViews();

        // setup list cast
        setupRvCast();

        play_fab.setOnClickListener(this);


    }

    void iniViews() {
        RvCast = findViewById(R.id.rv_Cast);
        play_fab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);
        // setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));



    }

    void setupRvCast() {

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name", R.drawable.ice_age_john_leguizamo));
        mdata.add(new Cast("name", R.drawable.ice_age_ray_romano));
        mdata.add(new Cast("name", R.drawable.ice_age_jessie_j));
        mdata.add(new Cast("name", R.drawable.ice_age_denis_leary));
        mdata.add(new Cast("name", R.drawable.ice_age_simon_pegg));
        mdata.add(new Cast("name", R.drawable.ice_age_queen_latifah));
        mdata.add(new Cast("name", R.drawable.ice_age_josh_peck));


        castAdapter = new CastAdapter(this, mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.play_fab){

            Intent intent = new Intent(MovieDetailActivity.this, MoviePlayerActivity.class);
            startActivity(intent);



        }



    }
}
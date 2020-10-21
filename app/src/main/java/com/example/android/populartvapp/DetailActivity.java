package com.example.android.populartvapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivPosterDetail;
    private TextView tvTitleDetail;
    private TextView tvFirstAirDateDetail;
    private TextView tvVoteAverageDetail;
    private TextView tvGenreDetail;

    private ArrayList<Integer> genreList;
    StringBuffer sbGenre = new StringBuffer();
    HashMap<Integer, String> genres = new HashMap<Integer, String>() {
        {
            put(28, "Action");
            put(10759, "Action & Adventure");
            put(16, "Animation");
            put(35, "Comedy");
            put(80, "Crime");
            put(99, "Documentary");
            put(18, "Drama");
            put(10751, "Family");
            put(10762, "Kids");
            put(9648, "Mystery");
            put(10763, "News");
            put(10764, "Reality");
            put(10765, "Sci-Fi & Fantasy");
            put(10766, "Soap");
            put(10767, "Talk");
            put(10768, "War & Politics");
            put(37, "Western");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initView();
        tvTitleDetail.setText(getIntent().getStringExtra("title"));
        tvFirstAirDateDetail.setText(getIntent().getStringExtra("first_air_date"));
        tvVoteAverageDetail.setText(getIntent().getStringExtra("vote_average"));
        genreList = getIntent().getIntegerArrayListExtra("genre");
        for (int i = 0; i < genreList.size(); i++) {
            sbGenre.append(genres.get(genreList.get(i)));
            sbGenre.append(", ");
        }
        sbGenre.setLength(sbGenre.length() - 2); // Hapus 2 karakter dibelakang string
        tvGenreDetail.setText(sbGenre.toString());
        Glide.with(DetailActivity.this).load(getIntent().getStringExtra("poster")).error(R.drawable.logonebula)
                .into(ivPosterDetail);
    }

    private void initView() {
        ivPosterDetail = findViewById(R.id.iv_poster_detail);
        tvTitleDetail = findViewById(R.id.tv_title_detail);
        tvFirstAirDateDetail = findViewById(R.id.tv_firstAirDate_detail);
        tvVoteAverageDetail = findViewById(R.id.tv_voteAverage_detail);
        tvGenreDetail = findViewById(R.id.tv_genre_detail);
    }

}
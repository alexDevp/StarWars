package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Film;

public class FilmDetailsActivity extends AppCompatActivity {

    private TextView text_view_title;
    private TextView text_view_episodeID;
    private TextView text_view_openingCrawl;
    private TextView text_view_director;
    private TextView text_view_producer;
    private TextView text_view_release_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        findViews();
        Film film = (Film) getIntent().getExtras().get("Film");
        setContents(film);
    }

    private void findViews(){
        this.text_view_title = findViewById(R.id.text_view_title_value);
        this.text_view_episodeID = findViewById(R.id.text_view_episodeID_value);
        this.text_view_openingCrawl = findViewById(R.id.text_view_openingCrawl_value);
        this.text_view_director = findViewById(R.id.text_view_director_value);
        this.text_view_producer = findViewById(R.id.text_view_producer_value);
        this.text_view_release_date = findViewById(R.id.text_view_release_date_value);
    }

    private void setContents(Film film) {
        this.text_view_title.setText(film.getTitle());
        this.text_view_episodeID.setText(film.getEpisodeId());
        this.text_view_openingCrawl.setText(film.getOpeningCrawl());
        this.text_view_director.setText(film.getDirector());
        this.text_view_producer.setText(film.getProducer());
        this.text_view_release_date.setText(film.getReleaseDate());
    }
}
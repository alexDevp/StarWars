package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Film;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.ui.adapters.FilmsAdapter;
import com.alexdevp.starwars.ui.adapters.PlanetsAdapter;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryFilms;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryPlanets;

public class FilmsActivity extends AppCompatActivity implements DatabaseRepositoryFilms.OnDataAvailableCallBack{

    private FilmsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);
        recyclerView = findViewById(R.id.recycler_view_films);

        adapter = new FilmsAdapter(this, new FilmsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Film film) {
                Intent intent = new Intent(FilmsActivity.this, FilmDetailsActivity.class);
                intent.putExtra("Film", film);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseRepositoryFilms.getFilms(this, this);
    }

    @Override
    public void onSuccess(final Object films) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FilmsActivity.this.adapter.updateList((Film[]) films);
            }
        });
    }

    @Override
    public void onError(String Error) {
        Log.e("MainActivity", Error);
    }



}
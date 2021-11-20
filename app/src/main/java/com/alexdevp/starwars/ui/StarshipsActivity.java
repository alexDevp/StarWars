package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.Starship;
import com.alexdevp.starwars.ui.adapters.PlanetsAdapter;
import com.alexdevp.starwars.ui.adapters.StarshipsAdapter;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryPlanets;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryStarships;

public class StarshipsActivity extends AppCompatActivity implements DatabaseRepositoryStarships.OnDataAvailableCallBack {

    private StarshipsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starships);
        recyclerView = findViewById(R.id.recycler_view_spaceships);

        adapter = new StarshipsAdapter(this, new StarshipsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Starship starship) {
                Intent intent = new Intent(StarshipsActivity.this, StarshipDetailsActivity.class);
                intent.putExtra("Starship", starship);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseRepositoryStarships.getStarships(this, this);
    }

    @Override
    public void onSuccess(final Object starships) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StarshipsActivity.this.adapter.updateList((Starship[]) starships);
            }
        });
    }

    @Override
    public void onError(String Error) {
        Log.e("MainActivity", Error);
    }

}
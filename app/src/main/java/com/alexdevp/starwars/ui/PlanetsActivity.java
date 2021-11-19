package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.ui.adapters.PlanetsAdapter;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryPlanets;

public class PlanetsActivity extends AppCompatActivity implements DatabaseRepositoryPlanets.OnDataAvailableCallBack {

    private PlanetsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
        recyclerView = findViewById(R.id.recycler_view_planets);


        adapter = new PlanetsAdapter(this, new PlanetsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Planet planet) {
                Intent intent = new Intent(PlanetsActivity.this, PlanetDetailsActivity.class);
                intent.putExtra("Planet", planet);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseRepositoryPlanets.getPlanets(this, this);
    }

    @Override
    public void onSuccess(final Object planets) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                PlanetsActivity.this.adapter.updateList((Planet[]) planets);
            }
        });
    }

    @Override
    public void onError(String Error) {
        Log.e("MainActivity", Error);
    }
}
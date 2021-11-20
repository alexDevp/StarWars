package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.Specie;
import com.alexdevp.starwars.ui.adapters.PlanetsAdapter;
import com.alexdevp.starwars.ui.adapters.SpeciesAdapter;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryPlanets;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositorySpecies;

public class SpeciesActivity extends AppCompatActivity implements DatabaseRepositorySpecies.OnDataAvailableCallBack {

    private SpeciesAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species);
        recyclerView = findViewById(R.id.recycler_view_species);

        adapter = new SpeciesAdapter(this, new SpeciesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Specie specie) {
                Intent intent = new Intent(SpeciesActivity.this, SpecieDetailsActivity.class);
                intent.putExtra("Specie", specie);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseRepositorySpecies.getSpecies(this, this);
    }

    @Override
    public void onSuccess(final Object species) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SpeciesActivity.this.adapter.updateList((Specie[]) species);
            }
        });
    }

    @Override
    public void onError(String Error) {
        Log.e("MainActivity", Error);
    }
}
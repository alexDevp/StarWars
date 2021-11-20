package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.Vehicle;
import com.alexdevp.starwars.ui.adapters.VehiclesAdapter;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryPlanets;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryVehicles;

public class VehiclesActivity extends AppCompatActivity implements DatabaseRepositoryVehicles.OnDataAvailableCallBack {

    private VehiclesAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);
        recyclerView = findViewById(R.id.recycler_view_vehicles);

        adapter = new VehiclesAdapter(this, new VehiclesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Vehicle vehicle) {
                Intent intent = new Intent(VehiclesActivity.this, VehicleDetailsActivity.class);
                intent.putExtra("Vehicle", vehicle);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseRepositoryVehicles.getVehicles(this, this);
    }

    @Override
    public void onSuccess(final Object vehicles) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                VehiclesActivity.this.adapter.updateList((Vehicle[]) vehicles);
            }
        });
    }

    @Override
    public void onError(String Error) {
        Log.e("MainActivity", Error);
    }

}
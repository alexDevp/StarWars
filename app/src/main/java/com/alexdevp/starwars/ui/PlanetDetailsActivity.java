package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;
import com.google.gson.annotations.SerializedName;

public class PlanetDetailsActivity extends AppCompatActivity {

    private TextView name;
    private TextView rotationPeriod;
    private TextView orbitalPeriod;
    private TextView diameter;
    private TextView climate;
    private TextView gravity;
    private TextView terrain;
    private TextView surfaceWater;
    private TextView population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);
        findViews();
        Planet planet = (Planet) getIntent().getExtras().get("Planet");
        setContents(planet);
    }

    private void findViews() {
        this.name = findViewById(R.id.text_view_name_value);
        this.rotationPeriod = findViewById(R.id.text_view_rotation_value);
        this.orbitalPeriod = findViewById(R.id.text_view_orbital_value);
        this.diameter = findViewById(R.id.text_view_diameter_value);
        this.climate = findViewById(R.id.text_view_climate_value);
        this.gravity = findViewById(R.id.text_view_gravity_value);
        this.terrain = findViewById(R.id.text_view_terrain_value);
        this.surfaceWater = findViewById(R.id.text_view_surface_water_value);
        this.population = findViewById(R.id.text_view_population_value);
    }

    private void setContents(Planet planet){
        this.name.setText(planet.getName());
        this.rotationPeriod.setText(planet.getRotationPeriod());
        this.orbitalPeriod.setText(planet.getOrbitalPeriod());
        this.diameter.setText(planet.getDiameter());
        this.climate.setText(planet.getClimate());
        this.gravity.setText(planet.getGravity());
        this.terrain.setText(planet.getTerrain());
        this.surfaceWater.setText(planet.getSurfaceWater());
        this.population.setText(planet.getPopulation());
    }
}
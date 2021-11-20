package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;

public class PlanetDetailsActivity extends AppCompatActivity {

    private TextView text_view_name;
    private TextView text_view_rotationPeriod;
    private TextView text_view_orbitalPeriod;
    private TextView text_view_diameter;
    private TextView text_view_climate;
    private TextView text_view_gravity;
    private TextView text_view_terrain;
    private TextView text_view_surfaceWater;
    private TextView text_view_population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);
        findViews();
        Planet planet = (Planet) getIntent().getExtras().get("Planet");
        setContents(planet);
    }

    private void findViews() {
        this.text_view_name = findViewById(R.id.text_view_name_value);
        this.text_view_rotationPeriod = findViewById(R.id.text_view_rotation_value);
        this.text_view_orbitalPeriod = findViewById(R.id.text_view_orbital_value);
        this.text_view_diameter = findViewById(R.id.text_view_diameter_value);
        this.text_view_climate = findViewById(R.id.text_view_climate_value);
        this.text_view_gravity = findViewById(R.id.text_view_gravity_value);
        this.text_view_terrain = findViewById(R.id.text_view_terrain_value);
        this.text_view_surfaceWater = findViewById(R.id.text_view_surface_water_value);
        this.text_view_population = findViewById(R.id.text_view_population_value);
    }

    private void setContents(Planet planet){
        this.text_view_name.setText(planet.getName());
        this.text_view_rotationPeriod.setText(planet.getRotationPeriod());
        this.text_view_orbitalPeriod.setText(planet.getOrbitalPeriod());
        this.text_view_diameter.setText(planet.getDiameter());
        this.text_view_climate.setText(planet.getClimate());
        this.text_view_gravity.setText(planet.getGravity());
        this.text_view_terrain.setText(planet.getTerrain());
        this.text_view_surfaceWater.setText(planet.getSurfaceWater());
        this.text_view_population.setText(planet.getPopulation());
    }
}
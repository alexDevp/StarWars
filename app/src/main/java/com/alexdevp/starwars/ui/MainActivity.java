package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alexdevp.starwars.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupClickListeners();
    }

    private void setupClickListeners() {
        CardView planetsCard = findViewById(R.id.card_view_planets);
        CardView spaceShipsCard = findViewById(R.id.card_view_space_ships);
        CardView vehiclesCard = findViewById(R.id.card_view_vehicles);
        CardView peopleCard = findViewById(R.id.card_view_people);
        CardView filmsCard = findViewById(R.id.card_view_films);
        CardView speciesCard = findViewById(R.id.card_view_species);

        planetsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanetsActivity.class);
                startActivity(intent);
            }
        });
    }
}
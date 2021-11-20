package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Starship;
import com.alexdevp.starwars.model.Vehicle;

public class StarshipDetailsActivity extends AppCompatActivity {

    private TextView text_view_name;
    private TextView text_view_model;
    private TextView text_view_manufacturer;
    private TextView text_view_cost_in_credits;
    private TextView text_view_length;
    private TextView text_view_max_atmosphering_speed;
    private TextView text_view_crew;
    private TextView text_view_passengers;
    private TextView text_view_cargo_capacity;
    private TextView text_view_consumables;
    private TextView text_view_hyperdrive_rating;
    private TextView text_view_MGLT;
    private TextView text_view_starship_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_details);
        findViews();
        Starship starship = (Starship) getIntent().getExtras().get("Starship");
        setContents(starship);
    }

    private void findViews() {
        this.text_view_name = findViewById(R.id.text_view_name_value);
        this.text_view_model = findViewById(R.id.text_view_model_value);
        this.text_view_manufacturer = findViewById(R.id.text_view_manufacturer_value);
        this.text_view_cost_in_credits = findViewById(R.id.text_view_cost_in_credits_value);
        this.text_view_length = findViewById(R.id.text_view_length_value);
        this.text_view_max_atmosphering_speed = findViewById(R.id.text_view_max_atmosphering_speed_value);
        this.text_view_crew = findViewById(R.id.text_view_crew_value);
        this.text_view_passengers = findViewById(R.id.text_view_passengers_value);
        this.text_view_cargo_capacity = findViewById(R.id.text_view_cargo_capacity_value);
        this.text_view_consumables = findViewById(R.id.text_view_consumables_value);
        this.text_view_hyperdrive_rating = findViewById(R.id.text_view_hyperdrive_rating_value);
        this.text_view_MGLT = findViewById(R.id.text_view_MGLT_value);
        this.text_view_starship_class = findViewById(R.id.text_view_starship_class_value);
    }

    private void setContents(Starship starship) {
        this.text_view_name.setText(starship.getName());
        this.text_view_model.setText(starship.getModel());
        this.text_view_manufacturer.setText(starship.getManufacturer());
        this.text_view_cost_in_credits.setText(starship.getCost_in_credits());
        this.text_view_length.setText(starship.getLength());
        this.text_view_max_atmosphering_speed.setText(starship.getMax_atmosphering_speed());
        this.text_view_crew.setText(starship.getCrew());
        this.text_view_passengers.setText(starship.getPassengers());
        this.text_view_cargo_capacity.setText(starship.getCargo_capacity());
        this.text_view_consumables.setText(starship.getConsumables());
        this.text_view_hyperdrive_rating.setText(starship.getHyperdrive_rating());
        this.text_view_MGLT.setText(starship.getMGLT());
        this.text_view_starship_class.setText(starship.getStarship_class());
    }
}